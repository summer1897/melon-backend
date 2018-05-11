package com.solstice.melon.service;

import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.UserRole;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:57
 * @Description 用户角色关联操作服务层接口定义
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     *
     * @param userId
     * @return {@link List<Long>}
     */
    List<UserRole> queryRoles(Long userId);

    /**
     * 根据用户ID查询所有角色ID
     * @param userId
     * @return {@link List<Long>}
     */
    List<Long> queryByUserId(Long userId);

    /**
     * 查询某一角色所对应的所有用户
     * @param roleId
     * @return {@link UserRole}
     */
    List<UserRole> queryUsers(Long roleId);

    /**
     *
     * @param roleId
     * @return @{@link List<Long>}
     */
    List<Long> queryByRoleId(Long roleId);

    /**
     * 为用户绑定多个角色
     * @param userId
     * @param roleIds
     * @return {@link Integer}
     */
    Integer add(Long userId,Set<Long> roleIds);

    /**
     * 用户多个角色解绑
     * @param userId
     * @param roleIds
     * @return {@link Integer}
     */
    Integer delete(Long userId,Set<Long> roleIds);

}
