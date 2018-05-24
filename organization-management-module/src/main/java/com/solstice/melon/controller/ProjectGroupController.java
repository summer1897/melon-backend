package com.solstice.melon.controller;

import com.solstice.melon.service.IProjectGroupService;
import com.summer.base.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/24
 * @Time 11:15
 * @Description
 */
@RestController
@RequestMapping("/project-group")
public class ProjectGroupController {

    private static final Logger log = LoggerFactory.getLogger(ProjectGroupController.class);
    @Autowired
    private IProjectGroupService projectGroupService;

    @GetMapping("/lists.json/{departmentId}")
    public ResultVo lists(@PathVariable Long departmentId) {
        log.info("Controller layer: ProjectGroupController.lists()",departmentId);
        Assert.notNull(departmentId,"部门Id为空");
//        projectGroupService

        return ResultVo.fail();
    }

}

