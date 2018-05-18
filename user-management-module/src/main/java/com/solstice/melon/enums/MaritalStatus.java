package com.solstice.melon.enums;

import com.google.common.collect.Maps;
import com.summer.base.utils.ObjectUtils;

import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/14
 * @Time 17:15
 * @Description 婚姻状况枚举
 */
public enum MaritalStatus implements BaseEnum {

    UNMARRIED(0, "未婚", "unmarried"), MARRIED(1, "已婚", "married");

    private int code;
    private String description;
    private String eDescription;
    private static Map<Integer, MaritalStatus> valueMap = Maps.newHashMap();

    static {
        for (MaritalStatus maritalStatus : values()) {
            valueMap.put(maritalStatus.code, maritalStatus);
        }
    }

    MaritalStatus(int code, String description, String eDescription) {
        this.code = code;
        this.description = description;
        this.eDescription = eDescription;
    }

    public static MaritalStatus indexOf(int code) {
        MaritalStatus maritalStatus = valueMap.get(code);
        if(ObjectUtils.isNull(maritalStatus)) {
            throw new IllegalArgumentException("没有对应的婚姻状态枚举类型" + code);
        }
        return maritalStatus;
    }

    @Override
    public int getValue() {
        return this.code;
    }

    public String getDescription() {
        return description;
    }

    public String geteDescription() {
        return eDescription;
    }

    @Override
    public String toString() {
        return this.description + "--" + this.eDescription;
    }

}