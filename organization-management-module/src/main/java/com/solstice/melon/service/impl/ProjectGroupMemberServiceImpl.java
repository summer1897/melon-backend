package com.solstice.melon.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.dao.ProjectGroupMemberMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.domain.ProjectGroupMember;
import com.solstice.melon.service.IAccountCredentialsService;
import com.solstice.melon.service.IProjectGroupMemberService;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/25
 * @Time 11:35
 * @Description
 */
@Transactional
@Service("projectGroupMemberService")
public class ProjectGroupMemberServiceImpl extends BaseServiceImpl<ProjectGroupMemberMapper,ProjectGroupMember>
                                                                implements IProjectGroupMemberService {

    private static final Logger log = LoggerFactory.getLogger(ProjectGroupMemberServiceImpl.class);
    @Autowired
    private IAccountCredentialsService accountCredentialsService;

    @Override
    public List<String> queryMembers(Long projectId) {
        log.info("Service layer: ProjectGroupMemberServiceImpl.queryMembers({})",projectId);
        List<ProjectGroupMember> projectGroupMembers = this.selectList(Condition.create().eq("project_id", projectId));
        return this.queryMemberName(projectGroupMembers);
    }

    @Override
    public Map<Long, List<String>> queryMembers(List<Long> projectGroupIds) {
        log.info("Service layer: ProjectGroupMemberServiceImpl.queryMembers({})", JSON.toJSONString(projectGroupIds,true));

        Map<Long,List<String>> memberNamesMap = Maps.newHashMap();
        List<ProjectGroupMember> projectGroupMembers = this.selectList(Condition.create().in("project_group_id",projectGroupIds));
        if (ObjectUtils.isNotEmpty(projectGroupMembers)) {
            List<Long> memberIds = PropertyUtils.extractPropertyFromDomain(projectGroupMembers,"memberId",Long.class);
            List<AccountCredentials> accountCredentials = accountCredentialsService.selectList(Condition.create().in("id",memberIds));
            Map<Long,ProjectGroupMember> projectGroupMemberMap = PropertyUtils.extractPropertyFromDomainToMap(projectGroupMembers,
                                                                                                "memberId",
                                                                                                                Long.class);
            Map<Long,List<AccountCredentials>> accountCredentialsMap = Maps.newHashMap();
            for (AccountCredentials accountCredential : accountCredentials) {
                Long memberId = accountCredential.getId();
                ProjectGroupMember projectGroupMember = projectGroupMemberMap.get(memberId);
                if (ObjectUtils.isNotNull(projectGroupMember)) {
                    Long projectGroupId = projectGroupMember.getProjectGroupId();
                    List<AccountCredentials> accountCredentials1 = accountCredentialsMap.get(projectGroupId);
                    if (ObjectUtils.isNotNull(accountCredentials1)) {
                        accountCredentials1.add(accountCredential);
                    } else {
                        accountCredentials1 = Lists.newArrayList();
                        accountCredentials1.add(accountCredential);
                        accountCredentialsMap.put(projectGroupId,accountCredentials1);
                    }
                }
            }
           for (Long projectGroupId : accountCredentialsMap.keySet()) {
                List<AccountCredentials> accountCredentials1 = accountCredentialsMap.get(projectGroupId);
                List<String> memberNames = PropertyUtils.extractPropertyFromDomain(accountCredentials1,"userName",String.class);
                memberNamesMap.put(projectGroupId,memberNames);
           }
        }
        return memberNamesMap;
    }

    private List<String> queryMemberName(List<ProjectGroupMember> projectGroupMembers) {
        List<String> memberNames = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(projectGroupMembers)) {
            List<Long> memberIds = PropertyUtils.extractPropertyFromDomain(projectGroupMembers,"memberId",Long.class);
            List<AccountCredentials> accountCredentials = accountCredentialsService.selectList(Condition.create().in("id", memberIds));
            if (ObjectUtils.isNotEmpty(accountCredentials)) {
                memberNames.addAll(PropertyUtils.extractPropertyFromDomain(accountCredentials,"userName",String.class));
            }
        }
        return memberNames;
    }
}
