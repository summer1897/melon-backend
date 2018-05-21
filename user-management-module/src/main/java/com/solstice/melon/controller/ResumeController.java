package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.annotations.CurrentUser;
import com.solstice.melon.domain.Resume;
import com.solstice.melon.service.IResumeService;
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
    public ResultVo add(@RequestBody Resume resume){
        log.info("Controller layer: add({})", JSON.toJSONString(resume,true));

        Assert.isNull(resume,"上传简历为空");
        boolean flag = resumeService.insert(resume);
        if (flag) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json")
    public ResultVo lists(@CurrentUser Long userId) {
        log.info("Controller layer: lists({})",userId);

        Assert.isNull(userId,"用户不存在 userId is null");
        List<Resume> resumes = resumeService.queryResume(userId);
        if (ObjectUtils.isNotEmpty(resumes)) {
            return ResultVo.success(HttpStatus.STATUS_OK,resumes);
        }
        return ResultVo.fail();
    }

    @GetMapping("/delete.json/{id}")
    public ResultVo delete(@PathVariable Long id) {
        log.info("Controller layer: delete({})",id);

        Assert.isNull(id,"待删除简历Id不能为空!");
        boolean success = resumeService.deleteById(id);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

}
