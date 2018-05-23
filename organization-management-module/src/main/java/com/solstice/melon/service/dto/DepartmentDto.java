package com.solstice.melon.service.dto;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 15:41
 * @Description
 */
public class DepartmentDto implements Serializable {
    private static final long serialVersionUID = 6764750312893628318L;

    private Long id;
    /**
     * 部门所属公司Id
     */
    private CompanyDto companyDto;
    /**
     * 部门负责人Id
     */
    private Long headerId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门简介
     */
    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
