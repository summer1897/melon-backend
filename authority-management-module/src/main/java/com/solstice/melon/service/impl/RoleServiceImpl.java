package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.solstice.melon.dao.RoleMapper;
import com.solstice.melon.domain.Role;
import com.solstice.melon.exception.ServiceException;
import com.solstice.melon.service.IRoleService;
import com.solstice.melon.service.dto.SimpleRoleDto;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 11:00
 * @Description 服务层角色操作接口实现类
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService {

    private Logger log  = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public List<SimpleRoleDto> queryAllAvailableSimpleRoles() {
        log.info("Service layer=========>RoleServiceImpl.queryAllAvailableSimpleRoles()");

        List<Role> roles = this.selectList(Condition.create().eq("available",Role.AVAILABLE));

        List<SimpleRoleDto> simpleRoles = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(roles)) {
            simpleRoles.addAll(BeanCloneUtils.clone(roles,Role.class,SimpleRoleDto.class));
        }
        return simpleRoles;
    }

    @Override
    public List<Role> queryLikeName(String name) throws ServiceException {
        log.info("Service layer=========>RoleServiceImpl.queryLikeName({})",name);
        return this.selectList(Condition.create().like("name",name));
    }

    @Override
    public List<Role> queryAll() {
        log.info("Service layer=========>RoleServiceImpl.queryAll()");
        return this.selectList(Condition.EMPTY);
    }

    @Override
    public Page<Role> queryAllByPagination(Integer pageNum, Integer pageSize) {
        log.info("Service layer=========>RoleServiceImpl.queryAllByPagination()");
        Page<Role> page = new Page(pageNum,pageSize);
        this.selectPage(page,Condition.EMPTY);
        return page;
    }
}
