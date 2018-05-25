package com.solstice.melon.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.base.enums.HttpStatus;
import com.solstice.melon.controller.vo.DepartmentVo;
import com.solstice.melon.domain.Department;
import com.solstice.melon.service.IDepartmentService;
import com.solstice.melon.service.dto.DepartmentDto;
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
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody Department department) {
        log.info("Controller layer: ProjectGroupController.add({})",department);
        Assert.notNull(department,"添加部门信息为空");
        boolean success = departmentService.insert(department);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{companyId}")
    public ResultVo lists(@PathVariable Long companyId) {
        log.info("Controller layer: ProjectGroupController.lists()");

        Assert.notNull(companyId,"查询部门所属公司Id为空");
        List<DepartmentDto> departmentDtos = departmentService.queryByCompanyId(companyId);
        if (ObjectUtils.isNotEmpty(departmentDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK, BeanCloneUtils.deepClone(departmentDtos,DepartmentDto.class,DepartmentVo.class));
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{companyId}/{pageNum}/{pageSize}")
    public ResultVo lists(@PathVariable Long companyId,
                          @PathVariable Integer pageNum,
                          @PathVariable Integer pageSize) {
        log.info("Controller layer: ProjectGroupController.lists({},{},{})",companyId,pageNum,pageSize);

        Assert.notNull(companyId,"查询部门所属公司Id为空!");
        Assert.notNull(pageNum,"分页起始页码为空!");
        Assert.notNull(pageSize,"分页页面数据显示数量为空!");

        Page<DepartmentDto> departmentDtoPage = departmentService.queryByCompanyId(companyId,pageNum,pageSize);
        List<DepartmentDto> departmentDtos = departmentDtoPage.getRecords();
        if (ObjectUtils.isNotEmpty(departmentDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK,BeanCloneUtils.deepClone(departmentDtos,DepartmentDto.class,DepartmentVo.class));
        }
        return ResultVo.fail();
    }

    @GetMapping("/delete.json/{id}")
    public ResultVo delete(@PathVariable Long id) {
        log.info("Controller layer: ProjectGroupController.lists({})",id);
        Assert.notNull(id,"待删除部门信息Id为空!");
        boolean success = departmentService.deleteById(id);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

}
