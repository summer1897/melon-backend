package com.solstice.melon.service;

import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.Resume;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/18
 * @Time 16:28
 * @Description
 */
public interface IResumeService extends IService<Resume> {

    /**
     * 获取用户的所有简历信息
     * @param userId
     * @return {@link List<Resume>}
     */
    List<Resume> queryResume(Long userId);

}
