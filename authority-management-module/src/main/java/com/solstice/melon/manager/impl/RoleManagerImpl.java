package com.solstice.melon.manager.impl;


import com.google.common.collect.Lists;
import com.solstice.melon.controller.vo.RolePermissionVo;
import com.solstice.melon.manager.IRoleManager;
import com.solstice.melon.service.IRolePermissionService;
import com.solstice.melon.service.IRoleService;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 11:08
 * @Description
 */
@Transactional
@Component
public class RoleManagerImpl implements IRoleManager {

    private static final Logger log = LoggerFactory.getLogger(RoleManagerImpl.class);

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IRolePermissionService rolePermissionService;


    @Override
    public boolean authorize(RolePermissionVo rolePermissionVo) {
        log.info("Manager layer=============>RoleManagerImpl.authorize()");

        boolean isSuccess = false;
        if (ObjectUtils.isNotNull(rolePermissionVo)) {
            boolean flag1 = false,flag2 = false;
            Long roleId = rolePermissionVo.getRoleId();
            Set<Long> addingPermissionIds = rolePermissionVo.getAddingPermissionIds();
            Set<Long> deletingPermissionIds = rolePermissionVo.getDeletingPermissionIds();

            if (ObjectUtils.isNotNull(roleId) && ObjectUtils.isNotEmpty(addingPermissionIds)) {
                flag1 = rolePermissionService.correlation(roleId,addingPermissionIds);
            }
            if (ObjectUtils.isNotNull(roleId) && ObjectUtils.isNotEmpty(deletingPermissionIds)) {
                flag2 = rolePermissionService.uncorrelation(roleId,deletingPermissionIds);
            }

            isSuccess = flag1 || flag2;
        }
        return isSuccess;
    }

    @Override
    public boolean delete(Long id) {
        log.info("Manager layer=============>RoleManagerImpl.delete()");

        boolean isSuccess = false;
        if (ObjectUtils.isNotNull(id)) {
            isSuccess = roleService.deleteById(id) ||
                    rolePermissionService.uncorrelationAllPermissionOfRole(id);

        }
        return isSuccess;
    }

    @Override
    public boolean deleteBatch(Set<Long> ids) {
        log.info("Manager layer=============>RoleManagerImpl.deleteBatch()");

        boolean isSuccess = false;
        if (ObjectUtils.isNotEmpty(ids)) {
            //可能会存在有角色信息，但是没有角色权限关联信息的情况，所有
            //两个删除操作有可能只进行一种操作
            isSuccess = roleService.deleteBatchIds(ids) ||
                    rolePermissionService.uncorrelationAllPermissionOfRoles(ids);

        }
        return isSuccess;
    }

    @Override
    public List<Long> queryAllRolePermissionId(Long roleId) {
        log.info("Manager layer=============>RoleManagerImpl.queryAllRolePermissionId()");

        List<Long> permissionIds = Lists.newArrayList();
        if (ObjectUtils.isNotNull(roleId)) {
            permissionIds = rolePermissionService.queryPermissionOfRole(roleId);
        }
        return permissionIds;
    }
}
