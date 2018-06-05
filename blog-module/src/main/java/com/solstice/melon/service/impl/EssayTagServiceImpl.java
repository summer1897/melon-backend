package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.solstice.melon.dao.EssayTagMapper;
import com.solstice.melon.domain.EssayTag;
import com.solstice.melon.service.IEssayTagService;
import com.solstice.melon.service.dto.EssayTagDto;
import com.summer.base.utils.BeanCloneUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author yangyang
 * @Date 2018/6/1
 * @Time 14:36
 * @Description
 */
@Service("essayTagService")
public class EssayTagServiceImpl extends BaseServiceImpl<EssayTagMapper,EssayTag>
                                                    implements IEssayTagService {

    private static final Logger log = LoggerFactory.getLogger(EssayTagServiceImpl.class);

    @Override
    public List<EssayTagDto> selectByEssayId(Long essayId) {
        log.info("Service layer: EssayTagServiceImpl.selectByEssayId({})",essayId);
        List<EssayTag> essayTags = this.selectList(Condition.create().eq("essay_id", essayId));
        return BeanCloneUtils.clone(essayTags,EssayTag.class,EssayTagDto.class);
    }
}
