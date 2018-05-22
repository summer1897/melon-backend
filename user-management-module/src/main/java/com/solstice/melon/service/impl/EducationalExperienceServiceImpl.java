package com.solstice.melon.service.impl;

import com.solstice.melon.dao.EducationalExperienceMapper;
import com.solstice.melon.domain.EducationalExperience;
import com.solstice.melon.service.IEducationalExperienceService;
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
@Service("educationalExperienceService")
public class EducationalExperienceServiceImpl extends BaseServiceImpl<EducationalExperienceMapper,EducationalExperience>
                                                implements IEducationalExperienceService{

    private static final Logger log = LoggerFactory.getLogger(EducationalExperienceServiceImpl.class);
}
