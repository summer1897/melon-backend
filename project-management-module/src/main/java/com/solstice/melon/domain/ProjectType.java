package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 17:06
 * @Description
 */
public class ProjectType extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1978958333255842664L;
    /**
     * 项目类型
     */
    private String name;
    /**
     * 项目类型描述
     */
    private String description;

    public ProjectType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
