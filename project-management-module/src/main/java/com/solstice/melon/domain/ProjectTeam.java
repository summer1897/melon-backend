package com.solstice.melon.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/29
 * @Time 11:29
 * @Description 项目、项目团队关联实体类
 */
public class ProjectTeam extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 2348573040822772951L;

    private Long projectId;
    private Long teamId;

    public ProjectTeam() {
    }

    public ProjectTeam(Long projectId, Long teamId) {
        this.projectId = projectId;
        this.teamId = teamId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
