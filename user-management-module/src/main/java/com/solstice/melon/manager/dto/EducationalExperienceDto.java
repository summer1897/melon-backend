package com.solstice.melon.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 17:42
 * @Description
 */
public class EducationalExperienceDto implements Serializable {
    private static final long serialVersionUID = 8938577976963695730L;

    private Long id;

    /**
     * 毕业院校
     */
    private String graduateInstitutions;
    /**
     * 所学专业
     */
    private String major;
    /**
     * 专业学制
     */
    private Double yearOfMajor;
    /**
     * 专业研究方向介绍
     */
    private String researchDescription;
    /**
     * 证明人
     */
    private String reterence;
    /**
     * 起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getYearOfMajor() {
        return yearOfMajor;
    }

    public void setYearOfMajor(Double yearOfMajor) {
        this.yearOfMajor = yearOfMajor;
    }

    public String getResearchDescription() {
        return researchDescription;
    }

    public void setResearchDescription(String researchDescription) {
        this.researchDescription = researchDescription;
    }

    public String getReterence() {
        return reterence;
    }

    public void setReterence(String reterence) {
        this.reterence = reterence;
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
}
