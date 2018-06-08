package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.solstice.melon.domain.Project;
import com.solstice.melon.enums.Progress;
import com.solstice.melon.enums.ProgressSituation;

import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 14:53
 * @Description 项目管理Service层操作接口定义
 */
public interface IProjectService extends IBaseService<Project> {

    /**
     * 根据项目编号查询项目信息
     * @param number
     * @return {@link List<Project>}
     */
    List<Project> queryByNumber(String number);

    /**
     * 根据项目编号分页查询项目信息
     * @param number
     * @param pageNum
     * @param pageSize
     * @return {@link Page<Project>}
     */
    Page<Project> queryByNumber(String number,Integer pageNum,Integer pageSize);

    /**
     * 获取部门所有项目
     * @param departmentId
     * @return {@link List<Project>}
     */
    List<Project> queryByDepartmentId(Long departmentId);

    /**
     * 分页获取部门所有项目
     * @param departmentId
     * @param pageNum
     * @param pageSize
     * @return {@link Page<Project>}
     */
    Page<Project> queryByDepartmentId(Long departmentId,Integer pageNum,Integer pageSize);

    /**
     * 获取项目组所有项目
     * @param groupId
     * @return {@link List<Project>}
     */
    List<Project> queryByGroupId(Long groupId);

    /**
     * 分页获取项目组所有项目
     * @param groupId
     * @param pageNum
     * @param pageSize
     * @return {@link Page<Project>}
     */
    Page<Project> queryByGroupId(Long groupId,Integer pageNum,Integer pageSize);

    /**
     * 根据项目工期查询项目信息
     * @param startTime
     * @param endTime
     * @return {@link List<Project>}
     */
    List<Project> queryByDuration(Date startTime,Date endTime);

    /**
     * 根据项目工期分页查询项目信息
     * @param startTime
     * @param endTime
     * @param pageNum
     * @param pageSize
     * @return {@link Page<Project>}
     */
    Page<Project> queryByDuration(Date startTime,Date endTime,Integer pageNum,Integer pageSize);

    /**
     * 根据项目进度状态查询项目信息,如果项目已经开始，还可以指定更具体的项目进度{@link Progress}
     * 进行更精确的查询
     * @param progressSituation
     * @param progress
     * @return {@link List<Project>}
     */
    List<Project> queryByProgress(ProgressSituation progressSituation, Progress progress);

    /**
     * 根据项目进度状态分页查询项目信息,如果项目已经开始，还可以指定更具体的项目进度{@link Progress}
     * 进行更精确的查询
     * @param progressSituation
     * @param progress
     * @param pageNum
     * @param pageSize
     * @return {@link Page<Project>}
     */
    Page<Project> queryByProgress(ProgressSituation progressSituation, Progress progress,
                                  Integer pageNum, Integer pageSize);

}
