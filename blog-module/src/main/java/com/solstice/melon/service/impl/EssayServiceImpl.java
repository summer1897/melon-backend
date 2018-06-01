package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.dao.EssayMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.domain.Essay;
import com.solstice.melon.domain.EssayCategory;
import com.solstice.melon.service.*;
import com.solstice.melon.service.dto.EssayCommentDto;
import com.solstice.melon.service.dto.EssayDto;
import com.solstice.melon.service.dto.EssayTagDto;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 14:35
 * @Description
 */
@Transactional
@Service("essayService")
public class EssayServiceImpl extends BaseServiceImpl<EssayMapper,Essay> implements IEssayService {

    private static final Logger log = LoggerFactory.getLogger(EssayServiceImpl.class);
    @Autowired
    private IAccountCredentialsService accountCredentialsService;
    @Autowired
    private IEssayCategoryService essayCategoryService;
    @Autowired
    private IEssayTagService essayTagService;
    @Autowired
    private IEssayCommentService essayCommentService;

    @Override
    public EssayDto selectById(Long essayId) {
        log.info("Service layer: EssayServiceImpl.selectById({})",essayId);

        EssayDto essayDto = null;
        Essay essay = this.selectOne(Condition.create().eq("id",essayId));
        if (ObjectUtils.isNotNull(essay)) {
            essayDto = this.assemble(essay);
        }
        return essayDto;
    }

    @Override
    public List<EssayDto> selectByAuthorId(Long authorId) {
        log.info("Service layer: EssayServiceImpl.selectByAuthorId({})",authorId);
        List<Essay> essays = this.selectList(Condition.create().eq("author_id", authorId));
        List<EssayDto> essayDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(essays)) {
            essayDtos.addAll(this.assemble(essays));
        }
        return essayDtos;
    }

    @Override
    public Page<EssayDto> selectByAuthorIdPage(Long authorId, Integer pageNum, Integer pageSize) {
        log.info("Service layer: EssayServiceImpl.selectByAuthorIdPage({},{},{})",authorId,pageNum,pageSize);
        Page<Essay> page = new Page<>(pageNum,pageSize);
        this.selectPage(page,Condition.create().eq("author_id",authorId));

        Page<EssayDto> essayDtoPage = new Page<>(pageNum,pageSize);
        List<Essay> essays = page.getRecords();
        if (ObjectUtils.isNotEmpty(essays)){
            essayDtoPage.setRecords(this.assemble(essays));
        }
        return essayDtoPage;
    }

    private EssayDto assemble(Essay essay) {
        EssayDto essayDto = null;
        if (ObjectUtils.isNotNull(essay)) {
            essayDto = BeanCloneUtils.clone(essay,Essay.class,EssayDto.class);

            Long authorId = PropertyUtils.extractPropertyFromDomain(essay,"authorId",Long.class);
            AccountCredentials accountCredentials = null;
            if (ObjectUtils.isNotNull(authorId)) {
                accountCredentials = accountCredentialsService.selectById(authorId);
            }
            if (ObjectUtils.isNotNull(accountCredentials)) {
                essayDto.setAuthor(accountCredentials.getUserName());
            }

            Long essayCategoryId = PropertyUtils.extractPropertyFromDomain(essay,"essayCategoryId",Long.class);
            EssayCategory essayCategory = null;
            if (ObjectUtils.isNotNull(essayCategoryId)) {
                essayCategory = essayCategoryService.selectById(essayCategoryId);
            }
            if (ObjectUtils.isNotNull(essayCategory)) {
                essayDto.setEssayCategory(essayCategory.getName());
            }

            List<EssayTagDto> essayTagDtos = essayTagService.selectByEssayId(essayDto.getId());
            if (ObjectUtils.isNotEmpty(essayTagDtos)) {
                essayDto.setEssayTagDtos(essayTagDtos);
            }

            List<EssayCommentDto> essayCommentDtos = essayCommentService.selectByEssayIdPage(essayDto.getId(),
                                                                                            EssayCommentDto.DEFAUL_PAGE_NUM,
                                                                                            EssayCommentDto.DEFAUL_PAGE_SIZE);
            if (ObjectUtils.isNotEmpty(essayCommentDtos)) {
                essayDto.setEssayCommentDtos(essayCommentDtos);
            }
        }
        return essayDto;
    }

    private List<EssayDto> assemble(List<Essay> essays) {
        List<EssayDto> essayDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(essays)) {
            //获取随笔作者信息
            List<Long> authorIds = PropertyUtils.extractPropertyFromDomain(essays,"authorId",Long.class);
            Map<Long,AccountCredentials> authorMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(authorIds)) {
                List<AccountCredentials> authors = accountCredentialsService.selectList(Condition.create().in("id", authorIds));
                if (ObjectUtils.isNotEmpty(authors)) {
                    authorMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(authors,"id",Long.class));
                }
            }

            //获取个人随笔类别信息
            List<Long> essayCategoryIds = PropertyUtils.extractPropertyFromDomain(essays,"essayCategoryId",Long.class);
            Map<Long,EssayCategory> essayCategoryMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(essayCategoryIds)) {
                List<EssayCategory> essayCategories = essayCategoryService.selectList(Condition.create().in("id",essayCategoryIds));
                if (ObjectUtils.isNotEmpty(essayCategories)) {
                    essayCategoryMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(essayCategories,"id",Long.class));
                }
            }

            essayDtos.addAll(BeanCloneUtils.clone(essays,Essay.class,EssayDto.class));
            Map<Long,Essay> essayMap = PropertyUtils.extractPropertyFromDomainToMap(essays,"id",Long.class);
            if (ObjectUtils.isNotEmpty(essayMap)) {
                for (EssayDto essayDto : essayDtos) {
                    Essay essay = essayMap.get(essayDto.getId());
                    AccountCredentials accountCredentials = authorMap.get(essay.getAuthorId());
                    EssayCategory essayCategory = essayCategoryMap.get(essay.getEssayCategoryId());
                    essayDto.setAuthor(accountCredentials.getUserName());
                    essayDto.setEssayCategory(essayCategory.getName());
                }
            }
        }
        return essayDtos;
    }
}
