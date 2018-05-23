package com.solstice.melon.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 10:34
 * @Description 学位枚举
 */
public enum AcademicDegree implements BaseEnum {

    ILLITERACY(0,"文盲","illiteracy"),
    PRIMARY_SCHOOL(1,"小学","primary school"),
    MIDDLE_SCHOOL(2,"中学","middle school"),
    SENIOR_SCHOOL(3,"高学","senior school"),
    BACHELOR(4,"学士","bachelor"),
    SPECIAL_SECONDARY_SCHOOL(5,"中专","special secondary school"),
    JUNIOR_COLLEGE(6,"大专","junior college"),
    MASTER(7,"硕士","master"),
    DOCTOR(8,"博士","doctor"),
    POSTDOCTOR(9,"博士后","postdoctor");

    int value;
    String description;
    String eDescription;

    AcademicDegree(int value, String description, String eDescription) {
        this.value = value;
        this.description = description;
        this.eDescription = eDescription;
    }

    @Override
    public Serializable getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.description + "--" + this.eDescription;
    }
}
