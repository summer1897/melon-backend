package com.solstice.melon.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.Role;
import com.solstice.melon.service.dto.SimpleRoleDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:56
 * @Description 角色服务层操作接口
 */
public interface IRoleService extends IService<Role> {

    /**
     *
     * @return {@link SimpleRoleDto}
     */
    List<SimpleRoleDto> queryAllAvailableSimpleRoles();

    /**
     * 根据角色名称模糊查找角色对象
     * @param name 角色名称
     * @return {@link Role}
     */
    List<Role> queryLikeName(String name);

    /**
     * 查询所有角色对象
     * @return {@link List<Role>}
     */
    List<Role> queryAll();

    /**
     * 分页查询所有角色对象
     * @param pageNum 当前页起始下标
     * @param pageSize 当前页显示数据量
     * @return {@link Page<Role>}
     */
    Page<Role> queryAllByPagination(Integer pageNum, Integer pageSize);

}
