package com.solstice.melon.service;


import com.baomidou.mybatisplus.service.IService;
import com.solstice.melon.domain.AccountCredentials;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:36
 * @Description 用户登录服务层操作接口定义
 */
public interface IAccountCredentialsService extends IService<AccountCredentials> {

    /**
     *
     * @param userName
     * @return {@link AccountCredentials}
     */
    AccountCredentials queryByUserName(String userName);

}
