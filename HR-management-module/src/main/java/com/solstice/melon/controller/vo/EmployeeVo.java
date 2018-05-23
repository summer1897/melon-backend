package com.solstice.melon.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @Time 17:06
 * @Description
 */
public class EmployeeVo implements Serializable {
    private static final long serialVersionUID = 2168168082523211180L;

    private Long id;
    private String userName;
    /**
     * 用户昵称或姓名
     */
    private String nickName;
    /**
     * 职位
     */
    private String post;
    /**
     * 职称
     */
    private String title;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像存放路径
     */
    private String photoUrl;
    /**
     * 个人简介
     */
    private String selfIntroduction;
    /**
     * 户籍所在地
     */
    private String residenceAddress;
    /**
     * 当前所在地
     */
    private String currentAddress;
    /**
     * 参见工作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeOfEntry;

    private List<ResumeVo> resumeVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Date getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setTimeOfEntry(Date timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

    public List<ResumeVo> getResumeVos() {
        return resumeVos;
    }

    public void setResumeVos(List<ResumeVo> resumeVos) {
        this.resumeVos = resumeVos;
    }
}
