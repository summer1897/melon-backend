package com.solstice.melon.enums;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 10:53
 * @Description
 */
public enum CompanyStatus implements BaseEnum {

    UNLISTED(0,"未上市","Unlisted"),
    LISTED(1,"上市","Listed");

    int value;
    String description;
    String eDescription;

    CompanyStatus(int value, String description, String eDescription) {
        this.value = value;
        this.description = description;
        this.eDescription = eDescription;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }
}
