package com.solstice.melon.domain;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 11:38
 * @Description 博客随笔标签
 */
@TableName("blog_essay_tag")
public class EssayTag extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -5572288365647149352L;

    /**
     * 所属随笔Id
     */
    private Long essayId;
    private String name;

    public Long getEssayId() {
        return essayId;
    }

    public void setEssayId(Long essayId) {
        this.essayId = essayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
