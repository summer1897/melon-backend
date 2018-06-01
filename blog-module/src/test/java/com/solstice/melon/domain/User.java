package com.solstice.melon.domain;

import com.alibaba.fastjson.JSON;
import com.summer.base.utils.BeanCloneUtils;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 15:12
 * @Description
 */
public class User {
    private String userName;
    private String email;
    private String address;

    public User() {
    }

    public User(String userName, String email, String address) {
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        User user = new User("solstice","solstice@sina.com","贵阳市");
        User copier = BeanCloneUtils.clone(user, User.class, User.class);
        System.out.println(JSON.toJSONString(copier,true));
    }
}
