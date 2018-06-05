package com.solstice.melon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.CompanyStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 10:48
 * @Description 公司实体类
 */
public class Company extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -4579576574009304360L;

    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司创始人
     */
    private Long founderId;
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
    private Double registeredAssets;
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
    private CompanyStatus companyStatus;
    /**
     * 公司成立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFounderId() {
        return founderId;
    }

    public void setFounderId(Long founderId) {
        this.founderId = founderId;
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

    public Double getRegisteredAssets() {
        return registeredAssets;
    }

    public void setRegisteredAssets(Double registeredAssets) {
        this.registeredAssets = registeredAssets;
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

    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
