package com.solstice.melon.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solstice.melon.enums.DegreeOfEducation;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 17:48
 * @Description
 */
public class FamilyRelationshipDto implements Serializable {
    private static final long serialVersionUID = -3156331800994411298L;

    private Long id;
    /**
     * 与当事人关系
     */
    private String relationship;
    private String name;
    /**
     * 文化程度
     */
    private DegreeOfEducation degreeOfEducation;
    private String job;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DegreeOfEducation getDegreeOfEducation() {
        return degreeOfEducation;
    }

    public void setDegreeOfEducation(DegreeOfEducation degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
