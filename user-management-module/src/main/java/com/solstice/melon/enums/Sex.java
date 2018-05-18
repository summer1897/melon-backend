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
 * @Time 10:03
 * @Description 性别枚举
 */
public enum Sex implements BaseEnum {

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

    private static Map<Integer,Sex> valueMap = Maps.newHashMap();

    static {
        for (Sex sex : values()) {
            valueMap.put(sex.code,sex);
        }
    }

    Sex(int code,String sex,String eSex) {
        this.code = code;
        this.sex = sex;
        this.eSex = eSex;
    }

    public static Sex indexOf(int code) {
        Sex sex = valueMap.get(code);
        if(ObjectUtils.isNull(sex)) {
            throw new IllegalArgumentException("没有对应的性别枚举类型" + code);
        }
        return sex;
    }

    @Override
    public int getValue() {
        return this.code;
    }

    public String getSex() {
        return sex;
    }

    public String geteSex() {
        return eSex;
    }

    @Override
    public String toString() {
        return this.sex + "--" + this.eSex;
    }

}
