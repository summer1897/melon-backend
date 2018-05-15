package com.solstice.melon.enums;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 10:03
 * @Description 性别枚举
 */
public enum Sex {

    MALE(0,"男","male"),FEMALE(1,"女","female");

    /**
     * 性别二进制表示,0表示男，1表示女
     */
    private int code;
    /**
     * 性别中文表示
     */
    private String sex;
    /**
     * 性别英文表示
     */
    private String eSex;

    Sex(int code,String sex,String eSex) {
        this.code = code;
        this.sex = sex;
        this.eSex = eSex;
    }

    public static Sex indexOf(int code) {
        if (0 == code) {
            return MALE;
        } else if (1 == code) {
            return FEMALE;
        } else {
            return null;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

}
