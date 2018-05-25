package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.enums.HttpStatus;
import com.solstice.melon.controller.vo.CompanyVo;
import com.solstice.melon.domain.Company;
import com.solstice.melon.service.ICompanyService;
import com.solstice.melon.service.dto.CompanyDto;
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
 * @Time 10:01
 * @Description
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private ICompanyService companyService;

    @PostMapping(value = "/add.json")
    public ResultVo add(@RequestBody Company company) {
        log.info("Controller layer: CompanyController.add({})", JSON.toJSONString(company,true));
        Assert.notNull(company,"添加的公司信息为空");
        boolean success = false;
        try {
            success = companyService.insert(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @PostMapping("/update.json")
    public ResultVo update(@RequestBody Company company) {
        log.info("Controller layer: CompanyController.update({})", JSON.toJSONString(company,true));
        Assert.notNull(company,"更新的公司信息为空");
        boolean success = companyService.updateById(company);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json")
    public ResultVo lists() {
        log.info("Controller layer: CompanyController.lists()");
        List<CompanyDto> companyDtos = companyService.queryAll();
        if (ObjectUtils.isNotEmpty(companyDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK, BeanCloneUtils.clone(companyDtos,CompanyDto.class,CompanyVo.class));
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{pageNum}/{pageSize}")
    public ResultVo lists(@PathVariable Integer pageNum,@PathVariable Integer pageSize) {
        log.info("Controller layer: CompanyController.lists({},{})",pageNum,pageSize);
        Assert.notNull(pageNum,"分页起始页码为空");
        Assert.notNull(pageSize,"分页页面显示数据量大小为空");
        Page<CompanyDto> pageCompanyDtos = companyService.queryAll(pageNum,pageSize);
        List<CompanyDto> companyDtos = pageCompanyDtos.getRecords();
        if (ObjectUtils.isNotEmpty(companyDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK,BeanCloneUtils.clone(companyDtos,CompanyDto.class,CompanyVo.class));
        }
        return ResultVo.fail();
    }

    @GetMapping("/delete.json/{id}")
    public ResultVo delete(@PathVariable Long id) {
        log.info("Controller layer: CompanyController.delete({})",id);
        Assert.notNull(id,"待删除公司信息Id为空");
        boolean success = companyService.deleteById(id);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

}
