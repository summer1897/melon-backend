package com.solstice.melon.enums;


import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

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
    int value;
    /**
     * 性别中文表示
     */
    String description;
    /**
     * 性别英文表示
     */
    String eDescription;


    Sex(int value,String description,String eDescription) {
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
