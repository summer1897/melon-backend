package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.solstice.melon.domain.Essay;
import com.solstice.melon.service.dto.EssayDto;

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
public interface IEssayService extends IBaseService<Essay> {

    /**
     *
     * @param essayId
     * @return {@link EssayDto}
     */
    EssayDto selectById(Long essayId);

    /**
     *
     * @param authorId
     * @return {@link List<EssayDto>}
     */
    List<EssayDto> selectByAuthorId(Long authorId);

    /**
     *
     * @param authorId
     * @param pageNum
     * @param pageSize
     * @return {@link List<EssayDto>}
     */
    Page<EssayDto> selectByAuthorIdPage(Long authorId, Integer pageNum, Integer pageSize);

}
