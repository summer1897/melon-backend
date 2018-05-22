package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.WorkExperience;
import com.solstice.melon.service.IWorkExperienceService;
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
@RequestMapping("/work-experience")
public class WorkExperienceController {

    private static final Logger log = LoggerFactory.getLogger(WorkExperienceController.class);
    @Autowired
    private IWorkExperienceService workExperienceService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<WorkExperience> workExperience) {
        log.info("Controller layer: WorkExperienceController.list({})", JSON.toJSONString(workExperience,true));
        Assert.notEmpty(workExperience,"添加的工作经验为空");
        boolean success = false;
        try {
            success = workExperienceService.insertBatch(workExperience);
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
        log.info("Controller layer: WorkExperienceController.lists({})", resumeId);
        Assert.notNull(resumeId,"工作经验所属简历信息Id为空");
        List<WorkExperience> workExperiences = workExperienceService.queryByResumeId(resumeId);
        if (ObjectUtils.isNotEmpty(workExperiences)) {
            return ResultVo.success(HttpStatus.STATUS_OK,workExperiences);
        }
        return ResultVo.fail();
    }

}
