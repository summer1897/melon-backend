package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 14:30
 * @Description 项目合作部门关联实体类，主要指公司内部部门间的合作
 */
public class ProjectDepartment extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 3430395311536196307L;

    private Long departmentId;
    private Long projectId;

    public ProjectDepartment() {
    }

    public ProjectDepartment(Long departmentId, Long projectId) {
        this.departmentId = departmentId;
        this.projectId = projectId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
