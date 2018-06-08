package com.solstice.melon.service;

import com.solstice.melon.domain.EssayTag;
import com.solstice.melon.service.dto.EssayTagDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 14:24
 * @Description
 */
public interface IEssayTagService extends IBaseService<EssayTag> {

    /**
     * 查询随笔所有标签
     * @param essayId
     * @return {@link List<EssayTagDto>}
     */
    List<EssayTagDto> selectByEssayId(Long essayId);

}
