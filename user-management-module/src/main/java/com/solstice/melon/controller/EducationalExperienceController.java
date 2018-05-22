package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.EducationalExperience;
import com.solstice.melon.service.IEducationalExperienceService;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/22
 * @Time 10:48
 * @Description
 */
@RestController
@RequestMapping("/educational-experience")
public class EducationalExperienceController {

    private static final Logger log = LoggerFactory.getLogger(EducationalExperienceController.class);
    @Autowired
    private IEducationalExperienceService educationalExperienceService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<EducationalExperience> educationalExperiences) {
        log.info("Controller layer: EducationalExperienceController.list({})", JSON.toJSONString(educationalExperiences,true));
        Assert.notEmpty(educationalExperiences,"添加的教育经验为空");
        boolean success = false;
        try {
            success = educationalExperienceService.insertBatch(educationalExperiences);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{resumeId}")
    public ResultVo lists(@PathVariable Long resumeId) {
        log.info("Controller layer: EducationalExperienceController.lists({})", resumeId);
        Assert.notNull(resumeId,"教育经验所属简历信息Id为空");
        List<EducationalExperience> educationalExperiences = educationalExperienceService.queryByResumeId(resumeId);
        if (ObjectUtils.isNotEmpty(educationalExperiences)) {
            return ResultVo.success(HttpStatus.STATUS_OK,educationalExperiences);
        }
        return ResultVo.fail();
    }

}
