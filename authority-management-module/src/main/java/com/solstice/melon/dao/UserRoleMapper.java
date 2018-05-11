package com.solstice.melon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.solstice.melon.domain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 10:53
 * @Description
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户ID查询所有角色ID
     * @param userId
     * @return {@link List <Long>}
     */
    List<Long> queryByUserId(@Param("userId") Long userId);

    /**
     *
     * @param userId
     * @param roleIds
     * @return {@link Integer}
     */
    Integer add(@Param("userId") Long userId, @Param("roleIds") Set<Long> roleIds);

    /**
     *
     * @param userId
     * @param roleIds
     * @return {@link Integer}
     */
    Integer delete(@Param("userId") Long userId, @Param("roleIds") Set<Long> roleIds);

}
