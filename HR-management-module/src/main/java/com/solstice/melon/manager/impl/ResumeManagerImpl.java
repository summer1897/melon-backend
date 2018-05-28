package com.solstice.melon.manager.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.solstice.melon.domain.*;
import com.solstice.melon.manager.IResumeManager;
import com.solstice.melon.service.*;
import com.solstice.melon.service.dto.*;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
        this.assemble(resumeDtos);
        return resumeDtos;
    }

    @Override
    public boolean delete(Long resumeId) {
        log.info("ResumeManagerImpl.delete({})",resumeId);

        //先删除与简历相关的从属信息，最后再删除简历
        educationalExperienceService.delete(Condition.create().eq("resume_id",resumeId));
        schoolActivitiesService.delete(Condition.create().eq("resume_id",resumeId));
        schoolRewardService.delete(Condition.create().eq("resume_id",resumeId));
        workExperienceService.delete(Condition.create().eq("resume_id",resumeId));
        internshipExperienceService.delete(Condition.create().eq("resume_id",resumeId));
        resumeService.deleteById(resumeId);

        return true;
    }

    private void assemble(List<ResumeDto> resumeDtos) {
        if (ObjectUtils.isNotEmpty(resumeDtos)) {
            List<Long> resumeIds = PropertyUtils.extractPropertyFromDomain(resumeDtos,"id",Long.class);

            //教育经历
            List<EducationalExperience> educationalExperiences = educationalExperienceService.selectList(Condition.create().in("resume_id", resumeIds));
            Map<Long,List<EducationalExperience>> educationalExperienceMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(educationalExperiences)) {
                educationalExperienceMap.putAll(PropertyUtils.extractPropertyFromDomainToMapList(educationalExperiences, "resumeId", Long.class));
            }

            //在校活动
            List<SchoolActivities> schoolActivities = schoolActivitiesService.selectList(Condition.create().in("resume_id", resumeIds));
            Map<Long,List<SchoolActivities>> schoolActivitiesMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(schoolActivities)) {
                schoolActivitiesMap.putAll(PropertyUtils.extractPropertyFromDomainToMapList(schoolActivities, "resumeId", Long.class));
            }

            //在校奖励
            List<SchoolReward> schoolRewards = schoolRewardService.selectList(Condition.create().in("resume_id", resumeIds));
            Map<Long,List<SchoolReward>> schoolRewardsMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(schoolRewards)) {
                schoolRewardsMap.putAll(PropertyUtils.extractPropertyFromDomainToMapList(schoolRewards, "resumeId", Long.class));
            }

            //工作经历
            List<WorkExperience> workExperiences = workExperienceService.selectList(Condition.create().in("resume_id", resumeIds));
            Map<Long,List<WorkExperience>> workExperiencesMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(workExperiences)) {
                workExperiencesMap.putAll(PropertyUtils.extractPropertyFromDomainToMapList(workExperiences, "resumeId", Long.class));
            }

            //实习经历
            List<InternshipExperience> internshipExperiences = internshipExperienceService.selectList(Condition.create().in("resume_id", resumeIds));
            Map<Long,List<InternshipExperience>> internshipExperiencesMap = Maps.newHashMap();
            if (ObjectUtils.isNotEmpty(internshipExperiences)) {
                internshipExperiencesMap.putAll(PropertyUtils.extractPropertyFromDomainToMapList(internshipExperiences, "resumeId", Long.class));
            }

            for (ResumeDto resumeDto : resumeDtos) {
                Long resumeId = resumeDto.getId();

                List<EducationalExperience> educationalExperiences1 = educationalExperienceMap.get(resumeId);
                if (ObjectUtils.isNotEmpty(educationalExperiences1)) {
                    resumeDto.setEducationalExperienceDtos(BeanCloneUtils.clone(educationalExperiences1,
                                                                                EducationalExperience.class,
                                                                                EducationalExperienceDto.class));
                }

                List<SchoolActivities> schoolActivities1 = schoolActivitiesMap.get(resumeId);
                if (ObjectUtils.isNotEmpty(schoolActivities1)) {
                    resumeDto.setSchoolActivitiesDtos(BeanCloneUtils.clone(schoolActivities1,
                                                                            SchoolActivities.class,
                                                                            SchoolActivitiesDto.class));
                }

                List<SchoolReward> schoolRewards1 = schoolRewardsMap.get(resumeId);
                if (ObjectUtils.isNotEmpty(schoolRewards1)) {
                    resumeDto.setSchoolRewardDtos(BeanCloneUtils.clone(schoolRewards1,
                                                                        SchoolReward.class,
                                                                        SchoolRewardDto.class));
                }

                List<WorkExperience> workExperiences1 = workExperiencesMap.get(resumeId);
                if (ObjectUtils.isNotEmpty(workExperiences1)) {
                    resumeDto.setWorkExperienceDtos(BeanCloneUtils.clone(workExperiences1,
                                                                        WorkExperience.class,
                                                                        WorkExperienceDto.class));
                }

                List<InternshipExperience> internshipExperiences1 = internshipExperiencesMap.get(resumeId);
                if (ObjectUtils.isNotEmpty(internshipExperiences1)) {
                    resumeDto.setInternshipExperienceDtos(BeanCloneUtils.clone(internshipExperiences1,
                                                                                InternshipExperience.class,
                                                                                InternshipExperienceDto.class));
                }


               /* List<EducationalExperience> educationalExperiences = educationalExperiences = educationalExperienceService.queryByResumeId(resumeId);
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
                }*/
            }
        }
    }
}
