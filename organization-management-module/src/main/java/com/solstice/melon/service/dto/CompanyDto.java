package com.solstice.melon.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.CompanyStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 15:45
 * @Description
 */
public class CompanyDto implements Serializable {
    private static final long serialVersionUID = 104919535943604560L;

    private Long id;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司创始人
     */
    private String founder;
    /**
     * 公司经营类型
     */
    private String businessType;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 公司注册资产
     */
    private Double registredAssets;
    /**
     * 公司简介
     */
    private String introduction;
    /**
     * 公司邮箱
     */
    private String email;
    /**
     * 公司联系方式
     */
    private String phone;
    /**
     * 公司是否上市,0表示未上市，1表示已上市
     */
    private CompanyStatusEnum companyStatus;
    /**
     * 公司成立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRegistredAssets() {
        return registredAssets;
    }

    public void setRegistredAssets(Double registredAssets) {
        this.registredAssets = registredAssets;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CompanyStatusEnum getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatusEnum companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
