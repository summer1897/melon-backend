package com.solstice.melon.controller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/25
 * @Time 15:20
 * @Description
 */
public class DepartmentVo implements Serializable {
    private static final long serialVersionUID = 3447648945985995771L;

    private Long id;
    /**
     * 部门所属公司
     */
    private String company;
    /**
     * 部门负责人
     */
    private String header;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门简介
     */
    private String introduction;
    /**
     * 部门项目组
     */
    private List<String> groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
}
