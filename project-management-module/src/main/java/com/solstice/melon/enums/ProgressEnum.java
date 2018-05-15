package com.solstice.melon.enums;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 16:47
 * @Description 项目追踪进度枚举
 */
public enum ProgressEnum {

    UNSTART(0,"未开始"),
    RESEARCH(1,"可研"),
    REVIEW(2,"评审"),
    OUT_OF_THE_TREASURY(3,"出库"),
    BID(4,"投标"),
    CONTRACT(5,"合同"),
    FIRST_STAGE(6,"1阶段"),
    SECOND_STAGE(7,"2阶段"),
    THIRD_STAGE(8,"3阶段"),
    CHECK_AND_ACCEPT(9,"验收"),
    MAITENANCE(10,"维护");

    private int code;
    private String name;

    ProgressEnum(int code,String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
