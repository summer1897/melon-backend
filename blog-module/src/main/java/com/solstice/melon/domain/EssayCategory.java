package com.solstice.melon.domain;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 11:37
 * @Description 博客个人随笔类别实体类
 */
@TableName("blog_essay_category")
public class EssayCategory extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1298713345068327072L;

    /**
     * 个人随笔类别创建者Id
     */
    private Long creatorId;
    private String name;
    private String description;

    public EssayCategory() {
    }

    public EssayCategory(Long creatorId, String name, String description) {
        this.creatorId = creatorId;
        this.name = name;
        this.description = description;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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
