package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.dao.CompanyMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.domain.Company;
import com.solstice.melon.enums.CompanyStatusEnum;
import com.solstice.melon.service.IAccountCredentialsService;
import com.solstice.melon.service.ICompanyService;
import com.solstice.melon.service.dto.CompanyDto;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:30
 * @Description
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<CompanyMapper,Company> implements ICompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
    @Autowired
    private IAccountCredentialsService accountCredentialsService;

    @Override
    public CompanyDto queryOne(String name) {
        log.info("Service layer: CompanyServiceImpl.queryOne({})",name);
        return this.selectOne(Condition.create().eq("name",name));
    }

    @Override
    public List<CompanyDto> queryByType(String bussinessType) {
        log.info("Service layer: CompanyServiceImpl.queryByType({})",bussinessType);
        return this.selectList(Condition.create().eq("bussiness_type",bussinessType));
    }

    @Override
    public Page<CompanyDto> queryByType(String bussinessType, Integer pageNum, Integer pageSize) {
        log.info("Service layer: CompanyServiceImpl.queryByType({},{},{})",bussinessType,pageNum,pageSize);
        Page<Company> page = new Page<>(pageNum,pageSize);
        return this.assemblePage(this.selectPage(page,Condition.create().eq("bussiness_type",bussinessType)));
    }

    @Override
    public List<CompanyDto> queryByStatus(CompanyStatusEnum companyStatus) {
        log.info("Service layer: CompanyServiceImpl.queryByStatus({})",companyStatus.getDescription());
        return this.assemble(this.selectList(Condition.create().eq("company_status",companyStatus.getValue())));
    }

    @Override
    public Page<CompanyDto> queryByStatus (CompanyStatusEnum companyStatus, Integer pageNum, Integer pageSize) {
        log.info("Service layer: CompanyServiceImpl.queryByStatus({},{},{})",companyStatus.getDescription(),pageNum,pageSize);
        Page<Company> page = new Page<>(pageNum,pageSize);
        return this.assemblePage(this.selectPage(page,Condition.create().eq("company_status",companyStatus.getValue())));
    }

    private Page<CompanyDto> assemblePage(Page<Company>  page) {
        Page<CompanyDto> page1 = new Page<>(page.getCurrent(),page.getSize());
        return page1.setRecords(this.assemble(page.getRecords()));
    }

    private List<CompanyDto> assemble(List<Company> companies) {
        List<CompanyDto> companyDtos = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(companies)) {
            List<Long> founderIds = PropertyUtils.extractPropertyFromDomain(companies,"founderId",Long.class);
            List<AccountCredentials> accountCredentials = accountCredentialsService.selectList(Condition.create().in("id", founderIds));
            Map<Long,AccountCredentials> accountCredentialsMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(accountCredentials)) {
                accountCredentialsMap.putAll(PropertyUtils.extractPropertyFromDomainToMap(accountCredentials,"id",Long.class));
            }

            companyDtos.addAll(BeanCloneUtils.clone(companies,Company.class,CompanyDto.class));
            Map<Long,CompanyDto> companyDtoMap = PropertyUtils.extractPropertyFromDomainToMap(companyDtos,"id",Long.class);
            for (Company company : companies) {
                Long id = company.getId();
                CompanyDto companyDto = companyDtoMap.get(id);
                companyDto.setFounder(accountCredentialsMap.get(company.getFounderId()).getUserName());
            }
        }

        return companyDtos;
    }
}
