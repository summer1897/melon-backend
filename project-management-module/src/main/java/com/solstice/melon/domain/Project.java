package com.solstice.melon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.Progress;
import com.solstice.melon.enums.ProgressSituation;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 16:39
 * @Description 项目实体类
 */
public class Project extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 8169377655609273983L;

    /**
     * 项目主要负责部门Id
     */
    private Long headerId;
    /**
     * 项目编号
     */
    private String number;
    /**
     * 项目甲方公司名称
     */
    private String employer;
    private String name;
    private Long typeId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Double totalFunds;
    private Double contractAmount;
    private Integer soft;
    private Integer report;
    private Integer standard;
    private Integer article;
    private Integer patent;
    private Integer softwareWorks;
    private Progress progress;
    private ProgressSituation progressSituation;
    /**
     * 项目负责组Id
     */
    private Long ownerGroupId;

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getTotalFunds() {
        return totalFunds;
    }

    public void setTotalFunds(Double totalFunds) {
        this.totalFunds = totalFunds;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Integer getSoft() {
        return soft;
    }

    public void setSoft(Integer soft) {
        this.soft = soft;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getArticle() {
        return article;
    }

    public void setArticle(Integer article) {
        this.article = article;
    }

    public Integer getPatent() {
        return patent;
    }

    public void setPatent(Integer patent) {
        this.patent = patent;
    }

    public Integer getSoftwareWorks() {
        return softwareWorks;
    }

    public void setSoftwareWorks(Integer softwareWorks) {
        this.softwareWorks = softwareWorks;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public ProgressSituation getProgressSituation() {
        return progressSituation;
    }

    public void setProgressSituation(ProgressSituation progressSituation) {
        this.progressSituation = progressSituation;
    }

    public Long getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(Long ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }
}
