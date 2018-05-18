package com.solstice.melon.enums;

import com.google.common.collect.Maps;
import com.summer.base.utils.ObjectUtils;

import java.util.Map;

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

    private static Map<Integer,AcademicDegree> valueMap = Maps.newHashMap();

    static {
        for (AcademicDegree academicDegree : values()) {
            valueMap.put(academicDegree.code,academicDegree);
        }
    }

    AcademicDegree(int code, String desc, String eDesc) {
        this.code = code;
        this.desc = desc;
        this.eDesc = eDesc;
    }

    public static AcademicDegree indexOf(int code) {
        AcademicDegree academicDegree = valueMap.get(code);
        if (ObjectUtils.isNull(academicDegree)) {
            throw new IllegalArgumentException("没有找着对应的学位枚举类型" + code);
        }
        return academicDegree;
    }

    @Override
    public int getValue() {
        return this.code;
    }

    public String getDesc() {
        return desc;
    }

    public String geteDesc() {
        return eDesc;
    }

    @Override
    public String toString() {
        return this.desc + "--" + this.eDesc;
    }
}
