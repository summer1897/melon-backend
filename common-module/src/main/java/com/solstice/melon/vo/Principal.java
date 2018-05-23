package com.solstice.melon.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 09:59
 * @Description
 */
public class Principal implements Serializable {
    private static final long serialVersionUID = -6202828955146226103L;

    /**
     * 用户状态，为激活（比如，邮箱注册，没有激活）
     */
    public static final byte STATUS_NO_ACTIVATION = 0;
    /**
     *  用户状态，正常
     */
    public static final byte STATUS_NO_NORMAL = 1;
    /**
     * 用户状态，已锁定
     */
    public static final byte STATUS_NO_LOCKED = 0;


    private Long id;

    /**
     * 用户账号
     */
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
     * 用户状态，0：创建未认证（比如，邮箱注册，没有激活），1：正常状态，2：用户被锁定
     */
    private Byte locked;
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

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
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
}
