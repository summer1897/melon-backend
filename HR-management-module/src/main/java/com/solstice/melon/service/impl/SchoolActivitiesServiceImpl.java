package com.solstice.melon.service.impl;

import com.solstice.melon.dao.SchoolActivitiesMapper;
import com.solstice.melon.domain.SchoolActivities;
import com.solstice.melon.service.ISchoolActivitiesService;
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
@Service("schoolActivitiesService")
public class SchoolActivitiesServiceImpl extends BaseServiceImpl<SchoolActivitiesMapper,SchoolActivities>
                                                implements ISchoolActivitiesService {

    private static final Logger log = LoggerFactory.getLogger(SchoolActivitiesServiceImpl.class);
}
