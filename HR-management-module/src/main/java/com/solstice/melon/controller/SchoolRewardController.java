package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.SchoolReward;
import com.solstice.melon.service.ISchoolRewardService;
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
@RequestMapping("/school-reward")*/
public class SchoolRewardController {

    private static final Logger log = LoggerFactory.getLogger(SchoolRewardController.class);
    @Autowired
    private ISchoolRewardService schoolRewardService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<SchoolReward> schoolRewards) {
        log.info("Controller layer: SchoolRewardController.list({})", JSON.toJSONString(schoolRewards,true));
        Assert.notEmpty(schoolRewards,"添加的获奖情况为空");
        boolean success = false;
        try {
            success = schoolRewardService.insertBatch(schoolRewards);
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
        Assert.notNull(resumeId,"获奖情况所属简历信息Id为空");
        List<SchoolReward> schoolRewards = schoolRewardService.queryByResumeId(resumeId);
        if (ObjectUtils.isNotEmpty(schoolRewards)) {
            return ResultVo.success(HttpStatus.STATUS_OK,schoolRewards);
        }
        return ResultVo.fail();
    }

}
