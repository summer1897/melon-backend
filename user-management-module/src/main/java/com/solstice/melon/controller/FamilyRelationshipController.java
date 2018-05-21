package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.enums.HttpStatus;
import com.solstice.melon.annotations.CurrentUser;
import com.solstice.melon.domain.FamilyRelationship;
import com.solstice.melon.service.IFamilyRelationshipService;
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
 * @Date 2018/5/21
 * @Time 16:26
 * @Description
 */
@RestController
@RequestMapping("/familyRelationship")
public class FamilyRelationshipController {

    private static final Logger log = LoggerFactory.getLogger(FamilyRelationshipController.class);
    @Autowired
    private IFamilyRelationshipService familyRelationshipService;

    @GetMapping("/list.json")
    public ResultVo lists(@CurrentUser Long userId) {
        log.info("Controller layer: FamilyRelationshipController.lists()");

        List<FamilyRelationship> familyRelationships = familyRelationshipService.queryAll(userId);
        if (ObjectUtils.isNotEmpty(familyRelationships)) {
            return ResultVo.success(HttpStatus.STATUS_OK,familyRelationships);
        }
        return ResultVo.fail();
    }

    @GetMapping("/list.json/{pageNum}/{pageSize}")
    public ResultVo lists(@CurrentUser Long userId,
                          @PathVariable Integer pageNum,
                          @PathVariable Integer pageSize) {
        log.info("Controller layer: FamilyRelationshipController.lists()");

        Page<FamilyRelationship> familyRelationships = familyRelationshipService.queryAll(userId,pageNum,pageSize);
        if (ObjectUtils.isNotEmpty(familyRelationships.getRecords())) {
            return ResultVo.success(HttpStatus.STATUS_OK,familyRelationships.getRecords());
        }
        return ResultVo.fail();
    }

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody List<FamilyRelationship> familyRelationship) {
        log.info("Controller layer: FamilyRelationshipController.add({})", JSON.toJSONString(familyRelationship,true));

        Assert.notEmpty(familyRelationship,"提交家属关系信息为空");
        boolean success = familyRelationshipService.insertBatch(familyRelationship);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @PostMapping("/update.json")
    public ResultVo update(@RequestBody FamilyRelationship familyRelationship) {
        log.info("Controller layer: FamilyRelationshipController.update({})", JSON.toJSONString(familyRelationship,true));

        Assert.isNull(familyRelationship,"提交家属关系信息为空");
        boolean success = familyRelationshipService.updateById(familyRelationship);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/delete.json")
    public ResultVo delete(@PathVariable Long id) {
        log.info("Controller layer: FamilyRelationshipController.delete({})",id);

        boolean success = familyRelationshipService.deleteById(id);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }


}
