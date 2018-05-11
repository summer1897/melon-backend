package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.User;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2017/05/11 10:55
 * @Description 用户操作接口
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名模糊查询
     * @param userName
     * @return {@link User}
     */
    List<User> queryLikeUserName(String userName);

    /**
     * 根据用户名才找用户
     * @param userName
     * @return {@link User},否则，返回null
     */
    User queryByName(String userName);

    /**
     * 查询所有用户
     * @return {@link List<User>}
     */
    List<User> queryAll();

    /**
     * 分页查询所有用户信息
     * @param pageNum 当前页其实位置
     * @param pageSize 当前页显示数据量
     * @return {@link List<User>}
     */
    Page<User> queryAllByPagination(Integer pageNum, Integer pageSize);

}
