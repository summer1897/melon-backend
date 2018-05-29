package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.ProjectGroupMember;
import com.solstice.melon.service.IProjectGroupMemberService;
import com.summer.base.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/29
 * @Time 9:33
 * @Description
 */
@RestController
@RequestMapping("/project-group-member")
public class ProjectGroupMemberController {

    private static final Logger log = LoggerFactory.getLogger(ProjectGroupMemberController.class);
    @Autowired
    private IProjectGroupMemberService projectGroupMemberService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<ProjectGroupMember> projectGroupMembers) {
        log.info("Controller layer: ProjectGroupMemberController.add({})", JSON.toJSONString(projectGroupMembers,true));
        Assert.notEmpty(projectGroupMembers,"添加项目组成员关系信息为空");
        boolean success = projectGroupMemberService.insertBatch(projectGroupMembers);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

}
