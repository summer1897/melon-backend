package com.solstice.melon.enums;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/14
 * @Time 17:15
 * @Description 婚姻状况枚举
 */
public enum  MaritalStatus {

    UNMARRIED(0,"未婚"),MARRIED(1,"已婚");

    private int status;
    private String descripion;
    MaritalStatus(int status,String descripion) {
        this.status = status;
        this.descripion = descripion;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }
}
