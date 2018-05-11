package com.solstice.melon.manager;


import com.solstice.melon.service.dto.AccountCredentialsDto;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:34
 * @Description 对外提供用户信息接口定义
 */
public interface IAccountCredentialsManager {

    AccountCredentialsDto queryByUserName(String userName);

    List<String> queryRoles(Long id);

    List<String> queryPermissions(Long id);
}
