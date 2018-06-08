package com.solstice.melon.service.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.solstice.melon.domain.BaseDomain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 14:46
 * @Description
 */
public class EssayDto extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -2288580330958379015L;
    private String author;
    private String essayCategory;
    private String title;
    private String content;
    private Integer visitedTimes;
    private Integer likedTimes;
    /**
     * 随笔标签
     */
    @JSONField(name = "essayTagVos")
    private List<EssayTagDto> essayTagDtos;
    /**
     * 随笔评论
     */
    @JSONField(name = "essayCommentVos")
    private List<EssayCommentDto> essayCommentDtos;

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

    public List<EssayTagDto> getEssayTagDtos() {
        return essayTagDtos;
    }

    public void setEssayTagDtos(List<EssayTagDto> essayTagDtos) {
        this.essayTagDtos = essayTagDtos;
    }

    public List<EssayCommentDto> getEssayCommentDtos() {
        return essayCommentDtos;
    }

    public void setEssayCommentDtos(List<EssayCommentDto> essayCommentDtos) {
        this.essayCommentDtos = essayCommentDtos;
    }
}
