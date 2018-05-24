package com.solstice.melon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.solstice.melon.domain.Company;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:05
 * @Description 公司Dao曾操作接口定义
 */
@Repository
public interface CompanyMapper extends BaseMapper<Company> {
}
