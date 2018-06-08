package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.Project;
import com.solstice.melon.service.IProjectService;
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
 * @Date 2018/5/29
 * @Time 15:33
 * @Description
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    private IProjectService projectService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody Project project) {
        log.info("Controller layer: ProjectController.add({})", JSON.toJSONString(project,true));
        Assert.notNull(project,"添加项目信息为空");
        boolean success = projectService.insert(project);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json")
    public ResultVo lists() {
        log.info("Controller layer: ProjectController.lists()");
        List<Project> projects = projectService.selectAll();
        if (ObjectUtils.isNotEmpty(projects)) {
            return ResultVo.success(HttpStatus.STATUS_OK,projects);
        }
        return ResultVo.fail();
    }

}
