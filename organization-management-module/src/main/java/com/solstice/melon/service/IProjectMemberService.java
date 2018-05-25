package com.solstice.melon.service;

import com.solstice.melon.domain.ProjectMember;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/25
 * @Time 10:51
 * @Description
 */
public interface IProjectMemberService extends IBaseService<ProjectMember> {

    /**
     * 查询项目成员所有Id
     * @param projectId
     * @return {@link List<Long>}
     */
    List<Long> queryMemberIds(Long projectId);

    /**
     * 查询某人参与过的所有项目Id
     * @param memberId
     * @return {@link List<Long>}
     */
    List<Long> queryProjectIds(Long memberId);

}
