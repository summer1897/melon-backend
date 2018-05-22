package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.InternshipExperience;
import com.solstice.melon.service.IInternshipExperienceService;
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
@RequestMapping("/internship-experience")
public class InternshipExperienceController {

    private static final Logger log = LoggerFactory.getLogger(InternshipExperienceController.class);
    @Autowired
    private IInternshipExperienceService internshipExperienceService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<InternshipExperience> internshipExperiences) {
        log.info("Controller layer: InternshipExperienceController.list({})", JSON.toJSONString(internshipExperiences,true));
        Assert.notEmpty(internshipExperiences,"添加的实习经验为空");
        boolean success = false;
        try {
            success = internshipExperienceService.insertBatch(internshipExperiences);
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
        log.info("Controller layer: InternshipExperienceController.lists({})", resumeId);
        Assert.notNull(resumeId,"实习经验所属简历信息Id为空");
        List<InternshipExperience> internshipExperiences = internshipExperienceService.queryByResumeId(resumeId);
        if (ObjectUtils.isNotEmpty(internshipExperiences)) {
            return ResultVo.success(HttpStatus.STATUS_OK,internshipExperiences);
        }
        return ResultVo.fail();
    }

}
