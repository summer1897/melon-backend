package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 11:06
 * @Description 部门项目组实体类
 */
public class ProjectGroup extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -3137093269299909489L;

    /**
     * 项目组组长Id
     */
    private Long groupLeaderId;
    /**
     * 项目组所属部门Id
     */
    private Long departmentId;
    private String name;
    /**
     * 项目组主要职责
     */
    private String responsibility;

    public ProjectGroup() {
    }

    public ProjectGroup(Long departmentId, String name, String responsibility) {
        this.departmentId = departmentId;
        this.name = name;
        this.responsibility = responsibility;
    }

    public Long getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(Long groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}
