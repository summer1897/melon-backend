package com.solstice.melon.enums;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 10:34
 * @Description 学位枚举
 */
public enum AcademicDegree {

    NON(0,"文盲","illiteracy"),
    PRIMARY_SCHOOL(1,"小学","primary school"),
    MIDDLE_SCHOOL(2,"中学","middle school"),
    SENIOR_SCHOOL(3,"高学","senior school"),
    BACHELOR(4,"学士","bachelor"),
    SPECIAL_SECONDARY_SCHOOL(5,"中专","special secondary school"),
    JUNIOR_COLLEGE(6,"大专","junior college"),
    MASTER(7,"硕士","master"),
    DOCTOR(8,"博士","doctor"),
    POSTDOCTOR(9,"博士后","postdoctor");

    private int code;
    private String desc;
    private String eDesc;

    AcademicDegree(int code, String desc, String eDesc) {
        this.code = code;
        this.desc = desc;
        this.eDesc = eDesc;
    }

    public static AcademicDegree indexOf(int code) {
        AcademicDegree[] academicDegrees = values();
        if (code < 0 || code > academicDegrees.length) {
            return null;
        }
        return academicDegrees[code];
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String geteDesc() {
        return eDesc;
    }

    public void seteDesc(String eDesc) {
        this.eDesc = eDesc;
    }
}
