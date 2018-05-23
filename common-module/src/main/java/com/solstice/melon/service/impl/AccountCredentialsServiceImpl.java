package com.solstice.melon.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.solstice.melon.dao.AccountCredentialsMapper;
import com.solstice.melon.domain.AccountCredentials;
import com.solstice.melon.service.IAccountCredentialsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author summer
 * @Date 2018/05/11
 * @Time 10:37
 * @Description
 */
@Service("accountCredentialsService")
public class AccountCredentialsServiceImpl extends ServiceImpl<AccountCredentialsMapper,AccountCredentials>
        implements IAccountCredentialsService {

    private static final Logger log = LoggerFactory.getLogger(AccountCredentialsServiceImpl.class);

    @Override
    public AccountCredentials queryByUserName(String userName) {
        log.info("Service layer==================>AccountCredentialsServiceImpl.queryByUserName({})",userName);

        return selectOne(Condition.create().eq("user_name",userName));
    }
}
