package com.solstice.melon.manager.impl;

import com.google.common.collect.Lists;
import com.solstice.melon.domain.*;
import com.solstice.melon.manager.IResumeManager;
import com.solstice.melon.manager.dto.*;
import com.solstice.melon.service.*;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 17:55
 * @Description
 */
@Component
@Transactional
public class ResumeManagerImpl implements IResumeManager {

    private static final Logger log = LoggerFactory.getLogger(ResumeManagerImpl.class);
    @Autowired
    private IResumeService resumeService;
    @Autowired
    private IEducationalExperienceService educationalExperienceService;
    @Autowired
    private ISchoolActivitiesService schoolActivitiesService;
    @Autowired
    private ISchoolRewardService schoolRewardService;
    @Autowired
    private IWorkExperienceService workExperienceService;
    @Autowired
    private IInternshipExperienceService internshipExperienceService;

    @Override
    public List<ResumeDto> queryByUserId(Long userId) {
        log.info("ResumeManagerImpl.queryByUserId({})",userId);

        List<ResumeDto> resumeDtos = Lists.newArrayList();

        List<Resume> resumes = resumeService.queryResume(userId);
        if (ObjectUtils.isNotEmpty(resumes)) {
            resumeDtos.addAll(BeanCloneUtils.clone(resumes,Resume.class,ResumeDto.class));
        }

        //填充简历信息
        this.composeResume(resumeDtos);
        return resumeDtos;
    }

    private void composeResume(List<ResumeDto> resumeDtos) {
        if (ObjectUtils.isNotEmpty(resumeDtos)) {
            for (ResumeDto resumeDto : resumeDtos) {
                Long resumeId = resumeDto.getId();

                List<EducationalExperience> educationalExperiences = educationalExperienceService.queryByResumeId(resumeId);
                if (ObjectUtils.isNotEmpty(educationalExperiences)) {
                    resumeDto.setEducationalExperienceDtos(BeanCloneUtils.clone(educationalExperiences,EducationalExperience.class,
                                                                                    EducationalExperienceDto.class));
                }

                List<SchoolActivities> schoolActivities = schoolActivitiesService.queryByResumeId(resumeId);
                if (ObjectUtils.isNotEmpty(schoolActivities)) {
                    resumeDto.setSchoolActivitiesDtos(BeanCloneUtils.clone(schoolActivities,SchoolActivities.class,SchoolActivitiesDto.class));
                }

                List<SchoolReward> schoolRewards = schoolRewardService.queryByResumeId(resumeId);
                if (ObjectUtils.isNotEmpty(schoolRewards)) {
                    resumeDto.setSchoolRewardDtos(BeanCloneUtils.clone(schoolRewards,SchoolReward.class,SchoolRewardDto.class));
                }

                List<WorkExperience> workExperiences = workExperienceService.queryByResumeId(resumeId);
                if (ObjectUtils.isNotEmpty(workExperiences)) {
                    resumeDto.setWorkExperienceDtos(BeanCloneUtils.clone(workExperiences,WorkExperience.class, WorkExperienceDto.class));
                }

                List<InternshipExperience> internshipExperiences = internshipExperienceService.queryByResumeId(resumeId);
                if (ObjectUtils.isNotEmpty(internshipExperiences)) {
                    resumeDto.setInternshipExperienceDtos(BeanCloneUtils.clone(internshipExperiences,InternshipExperience.class,InternshipExperienceDto.class));
                }
            }
        }
    }
}
