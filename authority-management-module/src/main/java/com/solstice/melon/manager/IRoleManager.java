package com.solstice.melon.manager;

import com.solstice.melon.controller.vo.RolePermissionVo;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 11:04
 * @Description
 */
public interface IRoleManager {

    /**
     * 为角色添加权限
     * @param rolePermissionVo
     * @return {@link boolean}
     */
    boolean authorize(RolePermissionVo rolePermissionVo);

    /**
     *
     * @param id
     * @return {@link boolean}
     */
    boolean delete(Long id);

    /**
     *
     * @param ids
     * @return {@link boolean}
     */
    boolean deleteBatch(Set<Long> ids);

    /**
     * 获取角色的所有权限Id
     * @param roleId
     * @return {@link List<Long>}
     */
    List<Long> queryAllRolePermissionId(Long roleId);

}
