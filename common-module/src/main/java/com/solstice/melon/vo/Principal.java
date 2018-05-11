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
    private String userName;
    private String nickName;
    private Byte sex;
    private String phone;
    private String email;
    private Byte locked;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;


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

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
