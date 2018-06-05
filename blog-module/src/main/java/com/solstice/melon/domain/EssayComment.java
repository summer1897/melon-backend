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
 * @Description 博客随笔评论实体类
 */
@TableName("blog_essay_comment")
public class EssayComment extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 6499024435739855423L;

    /**
     * 评论所属随笔Id
     */
    private Long essayId;
    /**
     * 评论人Id
     */
    private Long commentatorId;
    private String commentContent;

    public Long getEssayId() {
        return essayId;
    }

    public void setEssayId(Long essayId) {
        this.essayId = essayId;
    }

    public Long getCommentatorId() {
        return commentatorId;
    }

    public void setCommentatorId(Long commentatorId) {
        this.commentatorId = commentatorId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
