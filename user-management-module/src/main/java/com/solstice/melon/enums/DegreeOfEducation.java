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
 * @Time 10:09
 * @Description 文化程度枚举
 */
public enum DegreeOfEducation implements BaseEnum {

    NON(0,"文盲","illiteracy"),
    PRIMARY_SCHOOL(1,"小学","primary school"),
    MIDDLE_SCHOOL(2,"中学","middle school"),
    SENIOR_SCHOOL(3,"高学","senior school"),
    UNDERGRADUATE(4,"本科","undergraduate"),
    SPECIAL_SECONDARY_SCHOOL(5,"中专","special secondary school"),
    JUNIOR_COLLEGE(6,"大专","junior college"),
    POSTGRADUATE(7,"研究生","postgraduate"),
    DOCTOR(8,"博士","doctor"),
    POSTDOCTOR(8,"博士后","postdoctor");

    private int code;
    private String desc;
    private String eDesc;

    private static Map<Integer,DegreeOfEducation> valueMap = Maps.newHashMap();

    static {
        for (DegreeOfEducation degreeOfEducation : values()) {
            valueMap.put(degreeOfEducation.code,degreeOfEducation);
        }
    }

    DegreeOfEducation(int code,String desc,String eDesc) {
        this.code = code;
        this.desc = desc;
        this.eDesc = eDesc;
    }

    public static DegreeOfEducation indexOf(int code) {
        DegreeOfEducation degreeOfEducation = valueMap.get(code);
        if(ObjectUtils.isNull(degreeOfEducation)) {
            throw new IllegalArgumentException("没有对应的文化程度枚举类型" + code);
        }
        return degreeOfEducation;
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
