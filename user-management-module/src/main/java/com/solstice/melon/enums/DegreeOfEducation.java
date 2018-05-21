package com.solstice.melon.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.google.common.collect.Maps;
import com.summer.base.utils.ObjectUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 10:09
 * @Description 文化程度枚举
 */
public enum DegreeOfEducation implements IEnum {

    ILLITERACY(0,"文盲","illiteracy"),
    PRIMARY_SCHOOL(1,"小学","primary school"),
    MIDDLE_SCHOOL(2,"中学","middle school"),
    SENIOR_SCHOOL(3,"高学","senior school"),
    UNDERGRADUATE(4,"本科","undergraduate"),
    SPECIAL_SECONDARY_SCHOOL(5,"中专","special secondary school"),
    JUNIOR_COLLEGE(6,"大专","junior college"),
    POSTGRADUATE(7,"研究生","postgraduate"),
    DOCTOR(8,"博士","doctor"),
    POSTDOCTOR(8,"博士后","postdoctor");

    int value;
    String description;
    String eDescription;

    DegreeOfEducation(int value,String description,String eDescription) {
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
