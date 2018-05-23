package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author yangyang
 * @Date 2018/5/23
 * @Time 11:03
 * @Description 公司部门实体类
 */
public class Department extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 4379535729406288977L;

    /**
     * 部门所属公司Id
     */
    private Long companyId;
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

    public Department() {
    }

    public Department(Long companyId, Long headerId, String name, String introduction) {
        this.companyId = companyId;
        this.headerId = headerId;
        this.name = name;
        this.introduction = introduction;
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
