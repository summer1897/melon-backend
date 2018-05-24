package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.dao.ProjectGroupMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.domain.Department;
import com.solstice.melon.domain.ProjectGroup;
import com.solstice.melon.service.IAccountCredentialsService;
import com.solstice.melon.service.IDepartmentService;
import com.solstice.melon.service.IProjectGroupService;
import com.solstice.melon.service.dto.ProjectGroupDto;
import com.summer.base.utils.BeanCloneUtils;
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
 * @Date 2018/5/24
 * @Time 10:51
 * @Description
 */
@Service("projectGroupService")
@Transactional
public class ProjectGroupServiceImpl extends BaseServiceImpl<ProjectGroupMapper,ProjectGroup>
                                                            implements IProjectGroupService {

    private static final Logger log = LoggerFactory.getLogger(ProjectGroupServiceImpl.class);
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IAccountCredentialsService accountCredentialsService;

    @Override
    public List<ProjectGroupDto> queryByDepartmentId(Long departmentId) {
        log.info("Service layer: ProjectGroupServiceImpl.queryByDepartmentId({})",departmentId);
        return this.assemble(this.selectList(Condition.create().eq("department_id",departmentId)));
    }

    @Override
    public Page<ProjectGroupDto> queryByDepartmentId(Long departmentId, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectGroupServiceImpl.queryByDepartmentId({},{},{})",departmentId,pageNum,pageSize);
        Page<ProjectGroup> page = new Page<>(pageNum,pageSize);
        return this.assemblePaeg(this.selectPage(page,Condition.create().eq("department_id",departmentId)));
    }

    @Override
    public List<ProjectGroupDto> queryLikeByName(String name) {
        log.info("Service layer: ProjectGroupServiceImpl.queryLikeByName({})",name);
        return this.assemble(this.selectList(Condition.create().like("name",name)));
    }

    @Override
    public Page<ProjectGroupDto> queryLikeByName(String name, Integer pageNum, Integer pageSize) {
        log.info("Service layer: ProjectGroupServiceImpl.queryLikeByName({},{},{})",name,pageNum,pageSize);
        Page<ProjectGroup> page = new Page<>(pageNum,pageSize);
        return this.assemblePaeg(this.selectPage(page,Condition.create().like("name",name)));
    }

    private Page<ProjectGroupDto> assemblePaeg(Page<ProjectGroup> page) {
        Page<ProjectGroupDto> page1 = new Page<>(page.getCurrent(),page.getSize());
        return page1.setRecords(this.assemble(page.getRecords()));
    }

    private List<ProjectGroupDto> assemble(List<ProjectGroup> projectGroups) {
        List<ProjectGroupDto> projectGroupDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(projectGroups)) {

            //提取项目组组长Id
            List<Long> groupLeaderIds = PropertyUtils.extractPropertyFromDomain(projectGroups,"groupLeaderId",Long.class);
            List<AccountCredentials> accountCredentials = accountCredentialsService.selectList(Condition.create().in("id",groupLeaderIds));
            Map<Long,AccountCredentials> accountCredentialsMap =Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(accountCredentials)) {
                accountCredentialsMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(accountCredentials,"id",Long.class));
            }

            //提取所有部门Id
            List<Long> departmentIds = PropertyUtils.extractPropertyFromDomain(projectGroups,"departmentId",Long.class);
            List<Department> departments = departmentService.selectList(Condition.create().in("id", departmentIds));
            Map<Long,Department> departmentMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(departments)) {
                departmentMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(departments,"id",Long.class));
            }

            projectGroupDtos.addAll(BeanCloneUtils.clone(projectGroups,ProjectGroup.class,ProjectGroupDto.class));
            Map<Long,ProjectGroupDto> projectGroupDtoMap = PropertyUtils.extractPropertyFromDomainToMap(projectGroupDtos,"id",Long.class);
            for (ProjectGroup projectGroup : projectGroups) {
                Long id = projectGroup.getId();
                ProjectGroupDto projectGroupDto = projectGroupDtoMap.get(id);
                projectGroupDto.setGroupLeader(accountCredentialsMap.get(projectGroup.getGroupLeaderId()).getUserName());
                projectGroupDto.setDepartment(departmentMap.get(projectGroup.getDepartmentId()).getName());
            }
        }
        return projectGroupDtos;
    }
}
