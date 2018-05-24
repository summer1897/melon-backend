package com.solstice.melon.service.dto;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 11:25
 * @Description 简单的个人信息传输对象类
 */
public class SimpleEmployeeInfoDto implements Serializable {
    private static final long serialVersionUID = -6675475483023283037L;

    private Long id;
    private String userName;

    public SimpleEmployeeInfoDto() {
    }

    public SimpleEmployeeInfoDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

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
}
