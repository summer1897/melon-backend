package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 14:28
 * @Description 项目合作公司关联实体类
 */
public class ProjectCompany extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 8583426507967587527L;

    private Long companyId;
    private Long projectId;

    public ProjectCompany() {
    }

    public ProjectCompany(Long companyId, Long projectId) {
        this.companyId = companyId;
        this.projectId = projectId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
