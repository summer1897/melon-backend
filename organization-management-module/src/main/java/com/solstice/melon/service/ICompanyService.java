package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.solstice.melon.domain.Company;
import com.solstice.melon.enums.CompanyStatusEnum;
import com.solstice.melon.service.dto.CompanyDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:06
 * @Description 公司Service层操作接口定义
 */
public interface ICompanyService extends IBaseService<Company> {

    /**
     * 根据公司名称查找公司
     * @param name
     * @return {@link CompanyDto}
     */
    CompanyDto queryOne(String name);

    /**
     * 根据公司经营类型查询公司信息
     * @param bussinessType
     * @return {@link List<CompanyDto>}
     */
    List<CompanyDto> queryByType(String bussinessType);

    /**
     *
     * @param bussinessType
     * @param pageNum
     * @param pageSize
     * @return {@link Page<CompanyDto>}
     */
    Page<CompanyDto> queryByType(String bussinessType,Integer pageNum,Integer pageSize);

    /**
     * 根据公司是否上市属性查询公司信息
     * @param CompanyDtoStatus
     * @return {@link List<CompanyDto>}
     */
    List<CompanyDto> queryByStatus(CompanyStatusEnum CompanyDtoStatus);

    /**
     *
     * @param CompanyDtoStatus
     * @param pageNum
     * @param pageSize
     * @return {@link Page<CompanyDto>}
     */
    Page<CompanyDto> queryByStatus(CompanyStatusEnum CompanyDtoStatus, Integer pageNum, Integer pageSize);

}
