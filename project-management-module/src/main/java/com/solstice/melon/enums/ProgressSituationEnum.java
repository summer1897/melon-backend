package com.solstice.melon.enums;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 16:57
 * @Description 项目阶段状态枚举
 */
public enum ProgressSituationEnum {

    UNSTART(0,"未开始"),
    DOING(1,"进行中"),
    FINISHED(2,"已完成");

    private int code;
    private String name;

    ProgressSituationEnum(int code, String name) {
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
