package com.solstice.melon.enums;


import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/14
 * @Time 17:15
 * @Description 婚姻状况枚举
 */
public enum MaritalStatus implements IEnum {

    UNMARRIED(0, "未婚", "unmarried"), MARRIED(1, "已婚", "married");

    int value;
    String description;
    String eDescription;

    MaritalStatus(int value, String description, String eDescription) {
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