package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 10:03
 * @Description 定义一个继承 {@link IService}类的基础接口，并定义一些与{@link com.solstice.melon.domain.Resume}
 * 相关的通用方法
 */
public interface IBaseResumeService<T> extends IService<T> {

    /**
     * 根据简历Id查询与简历相关的多个信息
     * @param resumeId
     * @return {@link List<T>}
     */
    List<T> queryByResumeId(Long resumeId);

    /**
     * 分页查询与某简历相关的多个信息
     * @param resumeId
     * @param pageNum
     * @param pageSize
     * @return {@link Page<T>}
     */
    Page<T> queryByResumeIdAndPage(Long resumeId,Integer pageNum,Integer pageSize);



}
