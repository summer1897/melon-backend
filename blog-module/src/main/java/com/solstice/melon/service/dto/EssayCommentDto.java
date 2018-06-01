package com.solstice.melon.service.dto;

import com.solstice.melon.domain.BaseDomain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 16:38
 * @Description
 */
public class EssayCommentDto extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -6172763499422747923L;

    public static final Integer DEFAUL_PAGE_NUM = 1;
    public static final Integer DEFAUL_PAGE_SIZE = 8;

    private String commentator;
    private String commentContent;

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
