package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.Permission;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:57
 * @Description 权限Service操作接口定义
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 获取所有权限
     * @return List<Permission>
     */
    List<Permission> queryAll();

    /**
     * 分页获取所有权限
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    Page<Permission> queryAllAndPagination(Integer pageNum, Integer pageSize);


    /**
     * 根据多个权限ID查询其对应的所有权限,并分页返回
     * @param permissionIds
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    Page<Permission> queryByIdsAndPagination(Set<Long> permissionIds, Integer pageNum, Integer pageSize);

    /**
     * 查询当前权限的的所有子权限
     * @param permissionId
     * @return List<Permission>
     */
    List<Permission> queryChildren(Long permissionId);

    /**
     * 查询当前权限的的所有子权限，并分页返回
     * @param permissionId
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    Page<Permission> queryChildren(Long permissionId, Integer pageNum, Integer pageSize);

    /**
     * 根据多个权限ID查询其对应的所有子权限
     * @param permissionIds
     * @return List<Permission>
     */
    List<Permission> queryAllChildren(Set<Long> permissionIds);

    /**
     * 根据多个权限ID查询其对应的所有子权限,分页返回
     * @param permissionIds
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    Page<Permission> queryAllChildren(Set<Long> permissionIds, Integer pageNum, Integer pageSize);

    /**
     * 根据权限名称模糊查询权限
     * @param name
     * @return List<Permission>
     */
    List<Permission> queryLikeName(String name);

    /**
     * 根据权限名称模糊查询权限,分页返回
     * @param name
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    Page<Permission> queryLikeName(String name, Integer pageNum, Integer pageSize);

    /**
     * 更新权限信息
     * @param permission
     * @return {@link boolean}
     */
    boolean updateSelective(Permission permission);

}
