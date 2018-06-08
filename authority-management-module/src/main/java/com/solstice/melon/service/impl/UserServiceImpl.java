package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.solstice.melon.annotations.DbSource;
import com.solstice.melon.dao.UserMapper;
import com.solstice.melon.domain.User;
import com.solstice.melon.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:58
 * @Description
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User>
                            implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> queryLikeUserName(String userName) {
        log.info("Service layer========================>UserServiceImpl.queryLikeUserName({})",userName);
        return selectList(Condition.create().like("user_name",userName));
    }

    @Override
    public User queryByName(String userName) {
        log.info("Service layer========================>UserServiceImpl.queryByName({})",userName);
        return selectOne(Condition.create().eq("user_name",userName));
    }


    @Override
    @DbSource(name = "")
    public List<User> queryAll() {
        log.info("Service layer========================>UserServiceImpl.queryAll()");
        return selectList(Condition.EMPTY);
    }

    @Override
    public Page<User> queryAllByPagination(Integer pageNum, Integer pageSize) {
        log.info("Service layer=========>UserServiceImpl.queryAllByPagination({},{})",pageNum,pageSize);
        Page<User> page = new Page(pageNum,pageSize);
        selectPage(page,Condition.EMPTY);
        return page;
    }
}
