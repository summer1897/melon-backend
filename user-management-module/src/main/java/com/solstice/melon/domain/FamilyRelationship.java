package com.solstice.melon.domain;

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
 * @Date 2018/5/15
 * @Time 15:59
 * @Description 家属关系关联实体类
 */
public class FamilyRelationship extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -2378603697313274570L;

    /**
     *
     */
    private Long userId;
    /**
     * 与当事人关系
     */
    private String relationship;
    private String name;
    /**
     * 文化程度
     */
    private DegreeOfEducation degreeOfEducation;
    private String jpb;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getJpb() {
        return jpb;
    }

    public void setJpb(String jpb) {
        this.jpb = jpb;
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
