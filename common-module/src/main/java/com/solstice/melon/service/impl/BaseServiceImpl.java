package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.solstice.melon.service.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:25
 * @Description 通用Service层接口实现
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements IBaseService<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Override
    public Integer selectCount() {
        log.info("Service layer: {}.selectCount()",this.getClass());
        return this.selectCount(Condition.EMPTY);
    }

    @Override
    public List<T> selectAll() {
        log.info("Service layer: {}.selectAll()",this.getClass());
        return this.selectList(Condition.EMPTY);
    }

    @Override
    public Page<T> selectAll(Integer pageNum, Integer pageSize) {
        log.info("Service layer: {}.selectAll({},{})",this.getClass(),pageNum,pageSize);
        Page<T> page = new Page<>(pageNum,pageSize);
        return this.selectPage(page);
    }
}
