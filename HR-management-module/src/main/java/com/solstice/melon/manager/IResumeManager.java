package com.solstice.melon.manager;

import com.solstice.melon.service.dto.ResumeDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 17:35
 * @Description
 */
public interface IResumeManager {

    /**
     *
     * @param userId
     * @return {@link List<ResumeDto>}
     */
    List<ResumeDto> queryByUserId(Long userId);

    /**
     *
     * @param resumeId
     * @return {@link boolean}
     */
    boolean delete(Long resumeId);

}
