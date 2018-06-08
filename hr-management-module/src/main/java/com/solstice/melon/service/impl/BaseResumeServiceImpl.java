package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.solstice.melon.service.IBaseResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 10:19
 * @Description
 */
public class BaseResumeServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements IBaseResumeService<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseResumeServiceImpl.class);

    @Override
    public List<T> queryByResumeId(Long resumeId) {
        log.info("Service layer:{}.queryByResumeId({})",this.getClass(),resumeId);
        return this.selectList(Condition.create().eq("resume_id",resumeId));
    }

    @Override
    public Page<T> queryByResumeIdAndPage(Long resumeId, Integer pageNum, Integer pageSize) {
        log.info("Service layer:{}.queryByResumeId({},{},{})",this.getClass(),resumeId,pageNum,pageSize);
        Page<T> page = new Page<>(pageNum,pageSize);
        this.selectPage(page,Condition.create().eq("resume_id",resumeId));
        return page;
    }
}
