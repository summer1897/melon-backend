package com.solstice.melon.enums;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 16:57
 * @Description 项目阶段状态枚举
 */
public enum ProgressSituation implements BaseEnum {

    UNSTART(0,"未开始","Unstart"),
    DOING(1,"进行中","Doing"),
    FINISHED(2,"已完成","Finished");

    int value;
    String description;
    String eDescription;

    ProgressSituation(int value, String description, String eDescription) {
        this.value = value;
        this.description = description;
        this.eDescription = eDescription;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }
}
