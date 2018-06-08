package com.solstice.melon.domain;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 11:36
 * @Description 博客随笔实体类
 */
@TableName("blog_essay")
public class Essay extends BaseDomain implements Serializable{
    private static final long serialVersionUID = -2645295946262051350L;

    /**
     * 随笔作者Id
     */
    private Long authorId;
    /**
     * 转载随笔Id
     */
    private Long reprintedId;
    /**
     * 博客系统类别Id
     */
    private Long categoryId;
    /**
     * 个人创建随笔类别Id
     */
    private Long essayCategoryId;
    private String title;
    private String content;
    /**
     * 随笔被访问次数
     */
    private Integer visitedTimes;
    /**
     * 随笔被点赞次数
     */
    private Integer likedTimes;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getReprintedId() {
        return reprintedId;
    }

    public void setReprintedId(Long reprintedId) {
        this.reprintedId = reprintedId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getEssayCategoryId() {
        return essayCategoryId;
    }

    public void setEssayCategoryId(Long essayCategoryId) {
        this.essayCategoryId = essayCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVisitedTimes() {
        return visitedTimes;
    }

    public void setVisitedTimes(Integer visitedTimes) {
        this.visitedTimes = visitedTimes;
    }

    public Integer getLikedTimes() {
        return likedTimes;
    }

    public void setLikedTimes(Integer likedTimes) {
        this.likedTimes = likedTimes;
    }
}
