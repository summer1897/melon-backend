package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.solstice.melon.dao.UserRoleMapper;
import com.solstice.melon.domain.UserRole;
import com.solstice.melon.service.IUserRoleService;
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
 * @Date 2018/05/11 10:59
 * @Description
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService {

    private static final Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> queryRoles(Long userId) {
        log.info("Service layer: queryRoles()");
        return this.selectList(Condition.create().eq("user_id",userId));
    }

    @Override
    public List<Long> queryByUserId(Long userId) {
        log.info("Service layer========>UserRoleServiceImpl.queryByUserId()");
        return this.selectList(Condition.create().setSqlSelect("role_id").eq("user_id",userId));
    }

    @Override
    public List<UserRole> queryUsers(Long roleId) {
        log.info("Service layer: queryUsers()");
        return this.selectList(Condition.create().eq("role_id",roleId));
    }

    @Override
    public List<Long> queryByRoleId(Long roleId) {
        log.info("Service layer: queryByRoleId()");
        return this.selectList(Condition.create().setSqlSelect("user_id").eq("role_id",roleId));
    }

    @Override
    public Integer add(Long userId, Set<Long> roleIds) {
        log.info("Service layer: add()");
        return userRoleMapper.add(userId,roleIds);
    }

    @Override
    public Integer delete(Long userId, Set<Long> roleIds) {
        log.info("Service layer: delete()");
        return userRoleMapper.delete(userId,roleIds);
    }

}
