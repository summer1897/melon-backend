package com.solstice.melon.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.solstice.melon.dao.ProjectMapper;
import com.solstice.melon.domain.Project;
import com.solstice.melon.enums.Progress;
import com.solstice.melon.enums.ProgressSituation;
import com.solstice.melon.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/29
 * @Time 14:35
 * @Description
 */
@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl<ProjectMapper,Project> implements IProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Override
    public List<Project> queryByNumber(String number) {
        log.info("Service layer: ProjectServiceImpl.queryByNumber({})",number);
        return this.selectList(Condition.create().eq("number",number));
    }

    @Override
    public Page<Project> queryByNumber(String number, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectServiceImpl.queryByNumber({},{},{})",number,pageNum,pageSize);
        Page<Project> page = new Page<>(pageNum,pageSize);
        return this.selectPage(page,Condition.create().eq("number",number));
    }

    @Override
    public List<Project> queryByDepartmentId(Long departmentId) {
        log.info("Service layer: ProjectServiceImpl.queryByDepartmentId({})",departmentId);
        return this.selectList(Condition.create().eq("header_id",departmentId));
    }

    @Override
    public Page<Project> queryByDepartmentId(Long departmentId, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectServiceImpl.queryByDepartmentId({},{},{})",departmentId,pageNum,pageSize);
        Page<Project> page = new Page<>(pageNum,pageSize);
        return this.selectPage(page,Condition.create().eq("header_id",departmentId));
    }

    @Override
    public List<Project> queryByGroupId(Long groupId) {
        log.info("Service layer: ProjectServiceImpl.queryByGroupId({})",groupId);
        return this.selectList(Condition.create().eq("group_id",groupId));
    }

    @Override
    public Page<Project> queryByGroupId(Long groupId, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectServiceImpl.queryByGroupId({},{},{})",groupId,pageNum,pageSize);
        Page<Project> page = new Page<>(pageNum,pageSize);
        return this.selectPage(page,Condition.create().eq("group_id",groupId));
    }

    @Override
    public List<Project> queryByDuration(Date startTime, Date endTime) {
        log.info("Service layer: ProjectServiceImpl.queryByDuration({},{})", JSON.toJSONString(startTime,true),
                                                                            JSON.toJSONString(endTime,true));
        return this.selectList(Condition.create().eq("start_time",startTime).and().eq("end_time",endTime));
    }

    @Override
    public Page<Project> queryByDuration(Date startTime, Date endTime, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectServiceImpl.queryByDuration({},{})", JSON.toJSONString(startTime,true),
                                                                            JSON.toJSONString(endTime,true),
                                                                            pageNum,pageSize);
        Page<Project> page = new Page<>(pageNum,pageSize);
        return this.selectPage(page,Condition.create().eq("start_time",startTime).and().eq("end_time",endTime));
    }

    @Override
    public List<Project> queryByProgress(ProgressSituation progressSituation, Progress progress) {
        log.info("Service layer: ProjectServiceImpl.queryByProgress({},{})", JSON.toJSONString(progressSituation,true),
                                                                            JSON.toJSONString(progress,true));

        return this.selectList(this.getCondition(progressSituation,progress));
    }

    private Wrapper getCondition(ProgressSituation progressSituation, Progress progress) {
        Wrapper condition = null;
        if (ProgressSituation.DOING.getValue() == progressSituation.getValue()) {
            condition = Condition.create()
                    .eq("progress_situation", progressSituation.getValue())
                    .and()
                    .eq("progress", progress.getValue());
        } else {
            condition = Condition.create().eq("progress_situation", progressSituation.getValue());
        }
        return condition;
    }

    @Override
    public Page<Project> queryByProgress(ProgressSituation progressSituation, Progress progress, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectServiceImpl.queryByProgress({},{})", JSON.toJSONString(progressSituation,true),
                                                                            JSON.toJSONString(progress,true),pageNum,pageSize);
        Page<Project> page = new Page<>(pageNum,pageSize);
        return this.selectPage(page,this.getCondition(progressSituation,progress));
    }
}
