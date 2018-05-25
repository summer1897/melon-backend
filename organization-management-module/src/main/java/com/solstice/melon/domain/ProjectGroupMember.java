package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/25
 * @Time 11:29
 * @Description 项目组与成员关联实体类
 */
public class ProjectGroupMember extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -1350292477724392216L;

    /**
     * 项目组Id
     */
    private Long projectGroupId;
    /**
     * 项目成员Id
     */
    private Long memberId;

    public ProjectGroupMember() {
    }

    public ProjectGroupMember(Long projectGroupId, Long memberId) {
        this.projectGroupId = projectGroupId;
        this.memberId = memberId;
    }

    public Long getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(Long projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
