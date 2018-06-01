package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/29
 * @Time 11:27
 * @Description 项目、部门关联实体类
 */
public class ProjectDepartment extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 3430395311536196307L;

    private Long projectId;
    private Long departmentId;

    public ProjectDepartment() {
    }

    public ProjectDepartment(Long projectId, Long departmentId) {
        this.projectId = projectId;
        this.departmentId = departmentId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
