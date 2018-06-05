package com.solstice.melon.service.impl;

import com.solstice.melon.dao.InternshipExperienceMapper;
import com.solstice.melon.domain.InternshipExperience;
import com.solstice.melon.service.IInternshipExperienceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 10:12
 * @Description 实习经历Service层操作
 */
@Service("InternshipExperienceService")
public class InternshipExperienceServiceImpl extends BaseResumeServiceImpl<InternshipExperienceMapper,InternshipExperience>
                                            implements IInternshipExperienceService {

    private static final Logger log = LoggerFactory.getLogger(InternshipExperienceServiceImpl.class);
}
