package com.solstice.melon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/14
 * @Time 17:09
 * @Description 简历实体类
 */
public class Resume extends BaseDomain implements Serializable {

    /**
     * 简历所属者Id
     */
    private Long userId;
    private String name;
    private String resumePhotoUrl;
    private Sex sex;
    private MaritalStatus maritalStatus;
    private PoliticalStatus politicalStatus;
    private Nation nation;
    private DegreeOfEducation degreeOfEducation;
    private AcademicDegree academicDegree;
    private String phone;
    private String email;
    private String interestAndHobbies;
    private Byte isLatest;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResumePhotoUrl() {
        return resumePhotoUrl;
    }

    public void setResumePhotoUrl(String resumePhotoUrl) {
        this.resumePhotoUrl = resumePhotoUrl;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public PoliticalStatus getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(PoliticalStatus politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public DegreeOfEducation getDegreeOfEducation() {
        return degreeOfEducation;
    }

    public void setDegreeOfEducation(DegreeOfEducation degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterestAndHobbies() {
        return interestAndHobbies;
    }

    public void setInterestAndHobbies(String interestAndHobbies) {
        this.interestAndHobbies = interestAndHobbies;
    }

    public Byte getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(Byte isLatest) {
        this.isLatest = isLatest;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
