package com.solstice.melon.enums;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:34
 * @Description 登录用户状态信息
 */
public enum AccountSatus implements BaseEnum {

    UN_ACTIVATION_STATUS(0,"未激活"),
    NORMAL_STATUS(1,"正常"),
    FORBIDDEN_STATUS(2,"已禁用");

    /**
     * 状态码,0表示未激活，1表示正常，2表示已禁用
     */
    int status;
    /**
     * 状态描述
     */
    String description;


    private AccountSatus(int status,String description) {
        this.status = status;
        this.description = description;
    }

    @Override
    public Serializable getValue() {
        return this.status;
    }

    public int getStatus() {
        return this.status;
    }

}
