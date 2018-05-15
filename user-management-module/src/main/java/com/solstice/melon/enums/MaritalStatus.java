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
public enum MaritalStatus {

    UNMARRIED(0,"未婚","unmarried"),MARRIED(1,"已婚","married");

    private int code;
    private String description;
    private String eDescription;

    MaritalStatus(int code,String description,String eDescription) {
        this.code = code;
        this.description = description;
        this.eDescription = eDescription;
    }

    public static MaritalStatus indexOf(int code) {
        if (0 == code) {
            return UNMARRIED;
        } else if (1 == code) {
            return MARRIED;
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String geteDescription() {
        return eDescription;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription;
    }
}
