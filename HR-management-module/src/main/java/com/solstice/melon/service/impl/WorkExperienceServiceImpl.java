package com.solstice.melon.service.impl;

import com.solstice.melon.dao.WorkExperienceMapper;
import com.solstice.melon.domain.WorkExperience;
import com.solstice.melon.service.IWorkExperienceService;
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
@Service("workExperienceService")
public class WorkExperienceServiceImpl extends BaseResumeServiceImpl<WorkExperienceMapper,WorkExperience>
                                                implements IWorkExperienceService {

    private static final Logger log = LoggerFactory.getLogger(WorkExperienceServiceImpl.class);
}
