package com.solstice.melon.controller.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 17:09
 * @Description
 */
public class ResumeVo implements Serializable {
    private static final long serialVersionUID = 7206419214636110849L;

    private Long id;
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
    /**
     * 教育背景
     */
    private List<EducationalExperienceVo> educationalExperienceVos;
    /**
     * 学校活动
     */
    private List<SchoolActivitiesVo> schoolActivitiesVos;
    /**
     * 在校奖励
     */
    private List<SchoolRewardVo> schoolRewardVos;
    /**
     * 实习经历
     */
    private List<InternshipExperienceVo> internshipExperienceVos;
    /**
     * 工作经历
     */
    private List<WorkExperienceVo> workExperienceVos;

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

    public List<EducationalExperienceVo> getEducationalExperienceVos() {
        return educationalExperienceVos;
    }

    public void setEducationalExperienceVos(List<EducationalExperienceVo> educationalExperienceVos) {
        this.educationalExperienceVos = educationalExperienceVos;
    }

    public List<SchoolActivitiesVo> getSchoolActivitiesVos() {
        return schoolActivitiesVos;
    }

    public void setSchoolActivitiesVos(List<SchoolActivitiesVo> schoolActivitiesVos) {
        this.schoolActivitiesVos = schoolActivitiesVos;
    }

    public List<SchoolRewardVo> getSchoolRewardVos() {
        return schoolRewardVos;
    }

    public void setSchoolRewardVos(List<SchoolRewardVo> schoolRewardVos) {
        this.schoolRewardVos = schoolRewardVos;
    }

    public List<InternshipExperienceVo> getInternshipExperienceVos() {
        return internshipExperienceVos;
    }

    public void setInternshipExperienceVos(List<InternshipExperienceVo> internshipExperienceVos) {
        this.internshipExperienceVos = internshipExperienceVos;
    }

    public List<WorkExperienceVo> getWorkExperienceVos() {
        return workExperienceVos;
    }

    public void setWorkExperienceVos(List<WorkExperienceVo> workExperienceVos) {
        this.workExperienceVos = workExperienceVos;
    }
}
