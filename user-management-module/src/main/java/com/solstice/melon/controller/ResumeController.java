package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.google.common.collect.Lists;
import com.solstice.melon.annotations.CurrentUser;
import com.solstice.melon.domain.Resume;
import com.solstice.melon.enums.PoliticalStatus;
import com.solstice.melon.service.IResumeService;
import com.solstice.melon.vo.Principal;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author yangyang
 * @Date 2018/5/18
 * @Time 14:53
 * @Description
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    private static final Logger log = LoggerFactory.getLogger(ResumeController.class);
    @Autowired
    private IResumeService resumeService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody Resume resume) {
        log.info("Controller layer: add({})", JSON.toJSONString(resume,true));
        boolean flag = false;
        if (ObjectUtils.isNotNull(resume)) {
            flag = resumeService.insert(resume);
        }
        if (flag) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json")
    public ResultVo lists(@CurrentUser Long userId) {
        log.info("Controller layer: lists({})",userId);
        List<Resume> resumes = Lists.newArrayList();
        if (ObjectUtils.isNotNull(userId)) {
            resumes.addAll(resumeService.queryResume(userId));
        }
        if (ObjectUtils.isNotEmpty(resumes)) {
            return ResultVo.success(HttpStatus.STATUS_OK,resumes);
        }
        return ResultVo.fail();
    }

}
