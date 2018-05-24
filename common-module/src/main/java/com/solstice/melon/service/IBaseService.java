package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:19
 * @Description 基于{@link IService}接口之上再扩展一些常见接口
 */
public interface IBaseService<T> extends IService<T> {

    /**
     * 计算记录总数
     * @return {@link Integer}
     */
    Integer selectCount();

    /**
     *
     * @return {@link List<T>}
     */
    List<T> selectAll();

    /**
     * 分页获取所有信息
     * @param pageNum
     * @param pageSize
     * @return {@link Page<T>}
     */
    Page<T> selectAll(Integer pageNum,Integer pageSize);
}
