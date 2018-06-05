package com.solstice.melon.service.impl;

import com.solstice.melon.dao.SchoolRewardMapper;
import com.solstice.melon.domain.SchoolReward;
import com.solstice.melon.service.ISchoolRewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 9:36
 * @Description
 */
@Service("schoolRewardService")
public class SchoolRewardServiceImpl extends BaseResumeServiceImpl<SchoolRewardMapper,SchoolReward>
                                                implements ISchoolRewardService {

    private static final Logger log = LoggerFactory.getLogger(SchoolRewardServiceImpl.class);
}
