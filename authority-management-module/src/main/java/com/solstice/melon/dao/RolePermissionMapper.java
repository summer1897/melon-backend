package com.solstice.melon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.solstice.melon.domain.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:54
 * @Description DAO层操作
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 为角色添加权限信息
     * @param roleId
     * @param permissionIds
     * @return {@link Integer}
     */
    Integer correlations(Long roleId,Set<Long> permissionIds);

    /**
     * 移除角色的多个权限
     * @param roleId
     * @param permissionIds
     * @return {@link Integer}
     */
    Integer uncorrelations(Long roleId,Set<Long> permissionIds);

    /**
     * 删除多个角色及其对应的权限
     * @param roleIds
     * @param permissionIds
     * @return {@link boolean}
     */
    Integer uncorrelationRoles(Set<Long> roleIds, Set<Long> permissionIds);

    /**
     * 删除多个角色的所有权限
     * @param roleIds
     * @return {@link Long}
     */
    Integer uncorrelationAllPermissionOfRoles(Set<Long> roleIds);

}
