package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.FamilyRelationship;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/21
 * @Time 16:19
 * @Description
 */
public interface IFamilyRelationshipService extends IService<FamilyRelationship> {

    /**
     *
     * @param userId
     * @return {@link List<FamilyRelationship>}
     */
    List<FamilyRelationship> queryAll(Long userId);

    /**
     * 分页获取家属关系信息
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return {@link Page<FamilyRelationship>}
     */
    Page<FamilyRelationship> queryAll(Long userId,Integer pageNum,Integer pageSize);

}
