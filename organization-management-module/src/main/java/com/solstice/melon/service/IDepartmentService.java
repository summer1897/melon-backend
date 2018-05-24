package com.solstice.melon.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.solstice.melon.domain.Department;
import com.solstice.melon.service.dto.DepartmentDto;

import java.util.Collection;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 10:46
 * @Description 部门Service层操作接口定义
 */
public interface IDepartmentService extends IBaseService<Department> {

    /**
     *
     * @param column
     * @param values
     * @return {@link List<DepartmentDto>}
     */
    List<DepartmentDto> queryIn(String column, Collection<?> values);

    /**
     *
     * @param column
     * @param values
     * @param pageNum
     * @param pageSize
     * @return {@link Page<DepartmentDto>}
     */
    Page<DepartmentDto> queryIn(String column,Collection<?> values,Integer pageNum,Integer pageSize);

    /**
     *
     * @param name
     * @return {@link List<Department>}
     */
    List<DepartmentDto> queryLikeByName(String name);

    /**
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return {@link Page<Department>}
     */
    Page<DepartmentDto> queryLikeByName(String name, Integer pageNum, Integer pageSize);

}

