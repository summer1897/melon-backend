package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.SchoolActivities;
import com.solstice.melon.service.ISchoolActivitiesService;
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
/*@RestController
@RequestMapping("/school-activities")*/
public class SchoolActivitiesController {

    private static final Logger log = LoggerFactory.getLogger(SchoolActivitiesController.class);
    @Autowired
    private ISchoolActivitiesService schoolActivitiesService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<SchoolActivities> schoolActivities) {
        log.info("Controller layer: SchoolActivitiesController.list({})", JSON.toJSONString(schoolActivities,true));
        Assert.notEmpty(schoolActivities,"添加的在校活动情况为空");
        boolean success = false;
        try {
            success = schoolActivitiesService.insertBatch(schoolActivities);
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
        log.info("Controller layer: SchoolActivitiesController.lists({})", resumeId);
        Assert.notNull(resumeId,"在校活动情况所属简历信息Id为空");
        List<SchoolActivities> schoolActivities = schoolActivitiesService.queryByResumeId(resumeId);
        if (ObjectUtils.isNotEmpty(schoolActivities)) {
            return ResultVo.success(HttpStatus.STATUS_OK,schoolActivities);
        }
        return ResultVo.fail();
    }

}
