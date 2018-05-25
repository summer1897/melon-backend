package com.solstice.melon.service;

import com.solstice.melon.domain.ProjectGroupMember;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/25
 * @Time 11:31
 * @Description
 */
public interface IProjectGroupMemberService extends IBaseService<ProjectGroupMember> {

    /**
     * 查询项目组所有成员姓名
     * @param projectId
     * @return {@link List<String>}
     */
    List<String> queryMembers(Long projectId);

    /**
     * 查询多个项目组成员信息
     * @param projectIds
     * @return {@link Map<Long,List<String>>}
     */
    Map<Long,List<String>> queryMembers(List<Long> projectIds);

}
