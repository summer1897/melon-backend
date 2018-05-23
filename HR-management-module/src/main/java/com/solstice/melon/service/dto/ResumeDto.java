package com.solstice.melon.service.dto;

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
 * @Date 2018/5/22
 * @Time 17:40
 * @Description
 */
public class ResumeDto implements Serializable {
    private static final long serialVersionUID = 5080451786633004405L;

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
    @JSONField(name = "educationalExperienceVos")
    private List<EducationalExperienceDto> educationalExperienceDtos;
    /**
     * 学校活动
     */
    @JSONField(name = "schoolActivitiesVos")
    private List<SchoolActivitiesDto> schoolActivitiesDtos;
    /**
     * 在校奖励
     */
    @JSONField(name = "schoolRewardVos")
    private List<SchoolRewardDto> schoolRewardDtos;
    /**
     * 实习经历
     */
    @JSONField(name = "internshipExperienceVos")
    private List<InternshipExperienceDto> internshipExperienceDtos;
    /**
     * 工作经历
     */
    @JSONField(name = "workExperienceVos")
    private List<WorkExperienceDto> workExperienceDtos;

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

    public List<EducationalExperienceDto> getEducationalExperienceDtos() {
        return educationalExperienceDtos;
    }

    public void setEducationalExperienceDtos(List<EducationalExperienceDto> educationalExperienceDtos) {
        this.educationalExperienceDtos = educationalExperienceDtos;
    }

    public List<SchoolActivitiesDto> getSchoolActivitiesDtos() {
        return schoolActivitiesDtos;
    }

    public void setSchoolActivitiesDtos(List<SchoolActivitiesDto> schoolActivitiesDtos) {
        this.schoolActivitiesDtos = schoolActivitiesDtos;
    }

    public List<SchoolRewardDto> getSchoolRewardDtos() {
        return schoolRewardDtos;
    }

    public void setSchoolRewardDtos(List<SchoolRewardDto> schoolRewardDtos) {
        this.schoolRewardDtos = schoolRewardDtos;
    }

    public List<InternshipExperienceDto> getInternshipExperienceDtos() {
        return internshipExperienceDtos;
    }

    public void setInternshipExperienceDtos(List<InternshipExperienceDto> internshipExperienceDtos) {
        this.internshipExperienceDtos = internshipExperienceDtos;
    }

    public List<WorkExperienceDto> getWorkExperienceDtos() {
        return workExperienceDtos;
    }

    public void setWorkExperienceDtos(List<WorkExperienceDto> workExperienceDtos) {
        this.workExperienceDtos = workExperienceDtos;
    }
}
