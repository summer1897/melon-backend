package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.solstice.melon.dao.ResumeMapper;
import com.solstice.melon.domain.Resume;
import com.solstice.melon.service.IResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/18
 * @Time 16:29
 * @Description
 */
@Service("resumeService")
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper,Resume> implements IResumeService {

    private static final Logger log = LoggerFactory.getLogger(ResumeServiceImpl.class);

    @Override
    public List<Resume> queryResume(Long userId) {
        log.info("Service controller: queryResume({})",userId);
        return selectList(Condition.create().eq("user_id", userId));
    }
}
