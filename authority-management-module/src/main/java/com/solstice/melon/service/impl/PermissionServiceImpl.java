package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.solstice.melon.dao.PermissionMapper;
import com.solstice.melon.domain.Permission;
import com.solstice.melon.service.IPermissionService;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 11:02
 * @Description 权限服务层操作接口实现类
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission>
                                    implements IPermissionService {

    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Override
    public List<Permission> queryAll() {
        log.info("Service layer:=============>PermissionServiceImpl.queryAll()");
        return this.selectList(Condition.EMPTY);
    }

    @Override
    public Page<Permission> queryAllAndPagination(Integer pageNum, Integer pageSize) {
        log.info("Service layer:=============>PermissionServiceImpl.queryAllAndPagination()");
        Page<Permission> page = new Page(pageNum,pageSize);
        this.selectPage(page,Condition.EMPTY);
        return page;
    }


    @Override
    public Page<Permission> queryByIdsAndPagination(Set<Long> permissionIds, Integer pageNum, Integer pageSize) {
        log.info("Service layer:=============>PermissionServiceImpl.queryByIdsAndPagination()");
        Page<Permission> page = new Page(pageNum,pageSize);
        this.selectPage(page,Condition.create().in("id",permissionIds));
        return page;
    }

    @Override
    public List<Permission> queryChildren(Long permissionId) {
        log.info("Service layer:=============>PermissionServiceImpl.queryChildren()");
        return this.selectList(Condition.create().eq("parent_id",permissionId));
    }

    @Override
    public Page<Permission> queryChildren(Long permissionId, Integer pageNum, Integer pageSize) {
        log.info("Service layer:=============>PermissionServiceImpl.queryChildren()");
        Page<Permission> page = new Page(pageNum,pageSize);
        this.selectPage(page,Condition.create().eq("parent_id",permissionId));
        return page;
    }

    @Override
    public List<Permission> queryAllChildren(Set<Long> permissionIds) {
        log.info("Service layer:=============>PermissionServiceImpl.queryAllChildren()");
        return this.selectList(Condition.create().in("parent_id",permissionIds));
    }

    @Override
    public Page<Permission> queryAllChildren(Set<Long> permissionIds, Integer pageNum, Integer pageSize) {
        log.info("Service layer:=============>PermissionServiceImpl.queryAllChildren()");

        Page<Permission> page = new Page(pageNum,pageSize);
        this.selectPage(page,Condition.create().in("parent_id",permissionIds));
        return page;
    }

    @Override
    public List<Permission> queryLikeName(String name) {
        log.info("Service layer:=============>PermissionServiceImpl.queryLikeName()");
        return this.selectList(Condition.create().like("name",name));
    }

    @Override
    public Page<Permission> queryLikeName(String name, Integer pageNum, Integer pageSize) {
        log.info("Service layer:=============>PermissionServiceImpl.queryLikeName()");
        Page<Permission> page = new Page(pageNum,pageSize);
        this.selectPage(page,Condition.create().like("name",name));
        return page;
    }

    @Override
    public boolean updateSelective(Permission permission) {
        log.info("Service layer:=============>PermissionServiceImpl.queryByIdsAndPagination()");
        return this.updateById(permission);
    }
}
