package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.solstice.melon.domain.ProjectGroup;
import com.solstice.melon.service.dto.ProjectGroupDto;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:47
 * @Description 项目组Service层操作接口定义
 */
public interface IProjectGroupService extends IBaseService<ProjectGroup> {

    /**
     *
     * @param departmentId
     * @return {@link List<ProjectGroupDto>}
     */
    List<ProjectGroupDto> queryByDepartmentId(Long departmentId);

    /**
     *
     * @param departmentId
     * @param pageNum
     * @param pageSize
     * @return {@link Page<ProjectGroupDto>}
     */
    Page<ProjectGroupDto> queryByDepartmentId(Long departmentId,Integer pageNum,Integer pageSize);

    /**
     *
     * @param departmentIds
     * @return {@link List<ProjectGroupDto>}
     */
    Map<Long,List<ProjectGroupDto>> queryByDepartmentIds(List<Long> departmentIds);

    /**
     *
     * @param name
     * @return {@link List <ProjectGroup>}
     */
    List<ProjectGroupDto> queryLikeByName(String name);

    /**
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return {@link Page<ProjectGroupDto>}
     */
    Page<ProjectGroupDto> queryLikeByName(String name, Integer pageNum, Integer pageSize);

}
