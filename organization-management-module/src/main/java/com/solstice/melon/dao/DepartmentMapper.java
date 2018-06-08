package com.solstice.melon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.solstice.melon.domain.Department;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:43
 * @Description 部门Dao层操作接口定义
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
}
