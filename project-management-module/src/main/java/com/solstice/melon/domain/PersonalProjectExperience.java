package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/15
 * @Time 17:08
 * @Description 项目成员关联表
 */
public class PersonalProjectExperience extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -695545235176297601L;

    private Long projectId;
    private Long memberId;

    public PersonalProjectExperience(Long projectId, Long memberId) {
        this.projectId = projectId;
        this.memberId = memberId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
