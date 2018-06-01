package com.solstice.melon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.solstice.melon.domain.Project;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/23
 * @Time 14:51
 * @Description 项目管理Dao层操作接口定义
 */
@Repository
public interface ProjectMapper extends BaseMapper<Project> {
}
