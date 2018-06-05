package com.solstice.melon.enums;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 16:47
 * @Description 项目追踪进度枚举
 */
public enum Progress implements BaseEnum {

    UNSTART(0,"未开始","Unstart"),
    RESEARCH(1,"可研","Research"),
    REVIEW(2,"评审","Review"),
    OUT_OF_THE_TREASURY(3,"出库","Out of the treasury"),
    BID(4,"投标","Bid"),
    CONTRACT(5,"合同","Contract"),
    FIRST_STAGE(6,"1阶段","First stage"),
    SECOND_STAGE(7,"2阶段","Second stage"),
    THIRD_STAGE(8,"3阶段","Third stage"),
    CHECK_AND_ACCEPT(9,"验收","Check and accept"),
    MAITENANCE(10,"维护","Maintenance");

    int value;
    String description;
    String eDescription;

    Progress(int value, String description, String eDescription) {
        this.value = value;
        this.description = description;
        this.eDescription = eDescription;
    }

    @Override
    public Serializable getValue() {
        return value;
    }
}
