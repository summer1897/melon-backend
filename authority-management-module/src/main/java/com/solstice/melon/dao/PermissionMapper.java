package com.solstice.melon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.solstice.melon.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:53
 * @Description 权限DAO层操作接口定义
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

}
