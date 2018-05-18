package com.solstice.melon.domain;

import com.baomidou.mybatisplus.annotations.TableName;
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
 * @Time 10:33
 * @Description 用户登录凭证实体对象
 */
@TableName("user")
public class AccountCredentials extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -8904196835943433592L;

    private String userName;
    private String nickName;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Byte locked;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
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
