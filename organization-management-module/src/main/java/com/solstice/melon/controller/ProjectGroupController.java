package com.solstice.melon.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.base.enums.HttpStatus;
import com.solstice.melon.controller.vo.ProjectGroupVo;
import com.solstice.melon.domain.ProjectGroup;
import com.solstice.melon.service.IProjectGroupService;
import com.solstice.melon.service.dto.ProjectGroupDto;
import com.summer.base.utils.BeanCloneUtils;
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

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody ProjectGroup projectGroup) {
        log.info("Controller layer: ProjectGroupController.add({})",projectGroup);
        Assert.notNull(projectGroup,"添加项目组信息为空!");
        boolean success = projectGroupService.insert(projectGroup);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @PostMapping("/update.json")
    public ResultVo update(@RequestBody ProjectGroup projectGroup) {
        log.info("Controller layer: ProjectGroupController.update({})",projectGroup);
        Assert.notNull(projectGroup,"更新项目组信息为空!");
        boolean success = projectGroupService.updateById(projectGroup);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{departmentId}")
    public ResultVo lists(@PathVariable Long departmentId) {
        log.info("Controller layer: ProjectGroupController.lists({})",departmentId);
        Assert.notNull(departmentId,"部门Id为空");
        List<ProjectGroupDto> projectGroupDtos = projectGroupService.queryByDepartmentId(departmentId);
        if (ObjectUtils.isNotEmpty(projectGroupDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK, BeanCloneUtils.deepClone(projectGroupDtos,ProjectGroupDto.class, ProjectGroupVo.class));
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{departmentId}/{pageNum}/{pageSize}")
    public ResultVo lists(@PathVariable Long departmentId,
                          @PathVariable Integer pageNum,
                          @PathVariable Integer pageSize) {
        log.info("Controller layer: ProjectGroupController.lists({},{},{})",departmentId,pageNum,pageSize);
        Assert.notNull(departmentId,"部门Id为空!");
        Assert.notNull(pageNum,"分页起始页码为空!");
        Assert.notNull(pageSize,"分页页面数据显示数量为空!");
        Page<ProjectGroupDto> projectGroupDtoPage = projectGroupService.queryByDepartmentId(departmentId,pageNum,pageSize);
        List<ProjectGroupDto> projectGroupDtos = projectGroupDtoPage.getRecords();
        if (ObjectUtils.isNotEmpty(projectGroupDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK,BeanCloneUtils.deepClone(projectGroupDtos,ProjectGroupDto.class,ProjectGroupVo.class));
        }
        return ResultVo.fail();
    }

}

