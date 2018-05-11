package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.solstice.melon.dao.RolePermissionMapper;
import com.solstice.melon.domain.RolePermission;
import com.solstice.melon.service.IRolePermissionService;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 11:01
 * @Description
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper,RolePermission>
        implements IRolePermissionService {

    private static final Logger log = LoggerFactory.getLogger(RolePermissionServiceImpl.class);
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Long> queryPermissionOfRole(Long roleId) {
        log.info("Service layer============>RolePermissionServiceImpl.queryPermissionId()");
        return this.selectList(Condition.create().setSqlSelect("permission_id").eq("role_id",roleId));
    }

    @Override
    public List<Long> queryPermissionOfRoles(Set<Long> roleIds) {
        log.info("Service layer============>RolePermissionServiceImpl.queryPermissionId()");
        return this.selectList(Condition.create().setSqlSelect("permission_id").in("role_id",roleIds));
    }

    @Override
    public boolean correlation(Long roleId, Long permissionId) {
        log.info("Service layer============>RolePermissionServiceImpl.correlation()");
        Set<Long> permissionIds = Sets.newHashSet();
        permissionIds.add(permissionId);
        return this.correlation(roleId,permissionIds);
    }

    @Override
    public boolean correlation(Long roleId, Set<Long> permissionIds) {
        log.info("Service layer============>RolePermissionServiceImpl.correlation()");
        return retBool(rolePermissionMapper.correlations(roleId,permissionIds));
    }

    @Override
    public boolean uncorrelation(Long roleId, Long permissionId) {
        log.info("Service layer============>RolePermissionServiceImpl.uncorrelation()");
        Set<Long> permissionIds = Sets.newHashSet();
        permissionIds.add(permissionId);
        return this.uncorrelation(roleId,permissionIds);
    }

    @Override
    public boolean uncorrelation(Long roleId, Set<Long> permissionIds) {
        log.info("Service layer============>RolePermissionServiceImpl.uncorrelation()");
        return retBool(rolePermissionMapper.uncorrelations(roleId,permissionIds));
    }

    @Override
    public boolean uncorrelation(Set<Long> roleIds, Set<Long> permissionIds) {
        log.info("Service layer============>RolePermissionServiceImpl.uncorrelation()");
        return retBool(rolePermissionMapper.uncorrelationRoles(roleIds,permissionIds));
    }

    @Override
    public boolean uncorrelationAllPermissionOfRole(Long roleId) {
        log.info("Service layer============>RolePermissionServiceImpl.uncorrelationAllPermissionOfRole()");
        Set<Long> roleIds = Sets.newHashSet();
        roleIds.add(roleId);
        return this.uncorrelationAllPermissionOfRoles(roleIds);
    }

    @Override
    public boolean uncorrelationAllPermissionOfRoles(Set<Long> roleIds) {
        log.info("Service layer============>RolePermissionServiceImpl.uncorrelationAllPermissionOfRoles()");
        return retBool(rolePermissionMapper.uncorrelationAllPermissionOfRoles(roleIds));
    }
}
