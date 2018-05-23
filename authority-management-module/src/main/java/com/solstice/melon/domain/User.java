package com.solstice.melon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by summer on 2017/12/7.
 */
public class User extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 5811977737256559537L;

    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户昵称或姓名
     */
    private String nickName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 加密密码的盐
     */
    private String salt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public void setTimeOfEntry(Date timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

    public Date getTimeOfEntry() {
        return this.timeOfEntry;
    }

    /**
     * 密码盐（用于对明文密码进行加密）
     *
     * @return
     */
    public String getCredentialSalt() {
        return this.userName + this.salt;
    }

}
