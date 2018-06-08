package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.solstice.melon.domain.EssayCategory;
import com.solstice.melon.service.IEssayCategoryService;
import com.summer.base.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/6/1
 * @Time 15:50
 * @Description
 */
@RestController
@RequestMapping("/essay-category")
public class EssayCategoryController {

    private static final Logger log = LoggerFactory.getLogger(EssayCategoryController.class);
    @Autowired
    private IEssayCategoryService essayCategoryService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody EssayCategory essayCategory) {
        log.info("Controller layer: EssayCategoryController.add({})", JSON.toJSONString(essayCategory,true));
        Assert.notNull(essayCategory,"添加的个人随笔类别内容为空");
        boolean success = essayCategoryService.insert(essayCategory);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

}
