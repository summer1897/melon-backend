package com.solstice.melon.controller.vo;

import com.solstice.melon.domain.BaseDomain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 15:40
 * @Description
 */
public class EssayVo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -5326271460668817985L;
    private String author;
    private String essayCategory;
    private String title;
    private String content;
    private Integer visitedTimes;
    private Integer likedTimes;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEssayCategory() {
        return essayCategory;
    }

    public void setEssayCategory(String essayCategory) {
        this.essayCategory = essayCategory;
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
