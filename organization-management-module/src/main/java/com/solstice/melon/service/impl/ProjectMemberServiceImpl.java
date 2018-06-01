/*
package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.google.common.collect.Lists;
import com.solstice.melon.dao.ProjectMemberMapper;
import com.solstice.melon.domain.ProjectMember;
import com.solstice.melon.service.IProjectMemberService;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/25
 * @Time 10:52
 * @Description
 *//*

@Service("projectMemberService")
public class ProjectMemberServiceImpl extends BaseServiceImpl<ProjectMemberMapper,ProjectMember>
                                                            implements IProjectMemberService {

    private static final Logger log = LoggerFactory.getLogger(ProjectMemberServiceImpl.class);

    @Override
    public List<Long> queryMemberIds(Long projectId) {
        log.info("ProjectMemberServiceImpl.queryMemberIds({})",projectId);
        List<ProjectMember> projectMembers = this.selectList(Condition.create().eq("project_id", projectId));
        List<Long> memberIds = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(projectMembers)) {
            memberIds.addAll(PropertyUtils.extractPropertyFromDomain(projectMembers,"memberId",Long.class));
        }
        return memberIds;
    }

    @Override
    public List<Long> queryProjectIds(Long memberId) {
        log.info("ProjectMemberServiceImpl.queryProjectIds({})",memberId);
        List<ProjectMember> projectMembers = this.selectList(Condition.create().eq("member_id", memberId));
        List<Long> projectIds = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(projectMembers)) {
            projectIds.addAll(PropertyUtils.extractPropertyFromDomain(projectMembers,"projectId",Long.class));
        }
        return projectIds;
    }
}
*/
