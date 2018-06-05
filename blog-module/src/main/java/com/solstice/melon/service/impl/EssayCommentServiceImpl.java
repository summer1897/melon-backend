package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.dao.EssayCommentMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.domain.EssayComment;
import com.solstice.melon.service.IAccountCredentialsService;
import com.solstice.melon.service.IEssayCommentService;
import com.solstice.melon.service.dto.EssayCommentDto;
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
 * @Time 14:36
 * @Description
 */
@Transactional
@Service("essayCommentService")
public class EssayCommentServiceImpl extends BaseServiceImpl<EssayCommentMapper,EssayComment>
                                                            implements IEssayCommentService {

    private static final Logger log = LoggerFactory.getLogger(EssayCommentServiceImpl.class);
    @Autowired
    private IAccountCredentialsService accountCredentialsService;

    @Override
    public List<EssayCommentDto> selectByEssayId(Long essayId) {
        log.info("Service layer: EssayCommentServiceImpl.selectByEssayId({})",essayId);
        List<EssayComment> essayComments = this.selectList(Condition.create().eq("essay_id", essayId));
        List<EssayCommentDto> essayCommentDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(essayComments)) {
            essayCommentDtos.addAll(this.assemble(essayComments));
        }
        return essayCommentDtos;
    }

    @Override
    public List<EssayCommentDto> selectByEssayIdPage(Long essayId, Integer pageNum, Integer pageSize) {
        log.info("Service layer: EssayCommentServiceImpl.selectByEssayIdPage({},{},{})",essayId,pageNum,pageSize);
        Page<EssayComment> page = new Page<>(pageNum,pageSize);
        this.selectPage(page,Condition.create().eq("essay_id",essayId));
        return this.assemble(page.getRecords());
    }

    private List<EssayCommentDto> assemble(List<EssayComment> essayComments) {
        List<EssayCommentDto> essayCommentDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(essayComments)) {
            //获取随笔评论人信息
            List<Long> commentatorIds = PropertyUtils.extractPropertyFromDomain(essayComments,"commentatorId",Long.class);
            Map<Long,AccountCredentials> accountCredentialsMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(commentatorIds)) {
                List<AccountCredentials> accountCredentials = accountCredentialsService.selectList(Condition.create().in("id",commentatorIds));
                accountCredentialsMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(accountCredentials,"id",Long.class));
            }

            essayCommentDtos.addAll(BeanCloneUtils.clone(essayComments,EssayComment.class,EssayCommentDto.class));
            Map<Long,EssayComment> essayCommentMap = PropertyUtils.extractPropertyFromDomainToMap(essayComments,"id",Long.class);
            if ( ObjectUtils.isNotEmpty(accountCredentialsMap)) {
                for (EssayCommentDto essayCommentDto : essayCommentDtos) {
                    EssayComment essayComment = essayCommentMap.get(essayCommentDto.getId());
                    Long commentatorId = essayComment.getCommentatorId();
                    if (ObjectUtils.isNotNull(commentatorId)) {
                        essayCommentDto.setCommentator(accountCredentialsMap.get(commentatorId).getUserName());
                    }
                }
            }
        }
        return essayCommentDtos;
    }
}
