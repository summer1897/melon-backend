package com.solstice.melon.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.dao.DepartmentMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.domain.Company;
import com.solstice.melon.domain.Department;
import com.solstice.melon.service.IAccountCredentialsService;
import com.solstice.melon.service.ICompanyService;
import com.solstice.melon.service.IDepartmentService;
import com.solstice.melon.service.dto.DepartmentDto;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:48
 * @Description
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentMapper,Department>
                                            implements IDepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IAccountCredentialsService accountCredentialsService;

    @Override
    public List<DepartmentDto> queryIn(String column, Collection<?> values) {
        log.info("Service layer: DepartmentServiceImpl.queryIn({},{})",column, JSON.toJSONString(values,true));
        List<Department> departments = this.selectList(Condition.create().in(column, values));
        return this.assemble(departments);
    }

    @Override
    public Page<DepartmentDto> queryIn(String column, Collection<?> values, Integer pageNum, Integer pageSize) {
        log.info("Service layer: DepartmentServiceImpl.queryIn({},{},{},{})",column, JSON.toJSONString(values,true),
                                                                            pageNum,pageSize);
        Page<Department> page = new Page<>(pageNum,pageSize);
        return this.assemblePage(this.selectPage(page,Condition.create().in(column,values)));
    }

    @Override
    public List<DepartmentDto> queryLikeByName(String name) {
        log.info("Service layer: DepartmentServiceImpl.queryLikeByName({})",name);
        List<Department> departments = this.selectList(Condition.create().like("name", name));
        return this.assemble(departments);
    }

    @Override
    public Page<DepartmentDto> queryLikeByName(String name, Integer pageNum, Integer pageSize) {
        log.info("Service layer: DepartmentServiceImpl.queryLikeByName({},{},{})",name,pageNum,pageSize);
        Page<Department> page = new Page<>(pageNum,pageSize);
        return this.assemblePage(this.selectPage(page,Condition.create().like("name",name)));
    }

    private Page<DepartmentDto> assemblePage(Page<Department> page) {
        Page<DepartmentDto> page1 = new Page<>(page.getCurrent(),page.getSize());
        return page1.setRecords(this.assemble(page.getRecords()));
    }

    /**
     * 组装{@link DepartmentDto}
     * @param departments
     * @return {@link List<DepartmentDto>}
     */
    private List<DepartmentDto> assemble(List<Department> departments) {
        List<DepartmentDto> departmentDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(departments)) {
            List<Long> companyIds = PropertyUtils.extractPropertyFromDomain(departments,"companyId",Long.class);
            List<Company> companies = companyService.selectList(Condition.create().in("id", companyIds));
            Map<Long, Company> companyMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(companies)) {
                companyMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(companies, "id", Long.class));
            }

            List<Long> headerIds = PropertyUtils.extractPropertyFromDomain(departments,"headerId",Long.class);
            List<AccountCredentials> accountCredentials = accountCredentialsService.selectList(Condition.create().in("id", headerIds));
            Map<Long,AccountCredentials> accountCredentialsMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(accountCredentials)) {
                accountCredentialsMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(accountCredentials, "id", Long.class));
            }

            departmentDtos.addAll(BeanCloneUtils.clone(departments,Department.class,DepartmentDto.class));
            Map<Long,DepartmentDto> departmentDtoMap = PropertyUtils.extractPropertyFromDomainToMap(departmentDtos,"id",Long.class);
            for (Department department : departments) {
                Long id = department.getId();
                DepartmentDto departmentDto = departmentDtoMap.get(id);
                departmentDto.setCompany(companyMap.get(department.getCompanyId()).getName());
                departmentDto.setHeader(accountCredentialsMap.get(department.getHeaderId()).getUserName());
            }
        }
        return departmentDtos;
    }
}
