package com.solstice.melon.service;

import com.solstice.melon.domain.EssayComment;
import com.solstice.melon.service.dto.EssayCommentDto;

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
public interface IEssayCommentService extends IBaseService<EssayComment> {

    /**
     * 查询随笔所有评论信息
     * @param essayId
     * @return {@link List<EssayCommentDto>}
     */
    List<EssayCommentDto> selectByEssayId(Long essayId);

    /**
     * 分页查询随笔所有评论信息
     * @param essayId
     * @param pageNum
     * @param pageSize
     * @return {@link List<EssayCommentDto>}
     */
    List<EssayCommentDto> selectByEssayIdPage(Long essayId,Integer pageNum,Integer pageSize);

}
