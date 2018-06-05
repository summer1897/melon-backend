package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.enums.HttpStatus;
import com.solstice.melon.controller.vo.EssayVo;
import com.solstice.melon.domain.Essay;
import com.solstice.melon.service.IEssayService;
import com.solstice.melon.service.dto.EssayDto;
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
 * @Date 2018/6/1
 * @Time 15:41
 * @Description
 */
@RestController
@RequestMapping("/essay")
public class EssayController {

    private static final Logger log = LoggerFactory.getLogger(EssayController.class);
    @Autowired
    private IEssayService essayService;

    @PostMapping("/add.json")
    public ResultVo add(@RequestBody Essay essay) {
        log.info("Controller layer: EssayController.add({})", JSON.toJSONString(essay,true));
        Assert.notNull(essay,"发布的随笔内容为空");
        boolean success = essayService.insert(essay);
        if (success) {
            return ResultVo.success(HttpStatus.STATUS_OK);
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{authorId}")
    public ResultVo lists(@PathVariable Long authorId) {
        log.info("Controller layer: EssayController.lists({})", authorId);
        Assert.notNull(authorId,"查询作者为空");
        List<EssayDto> essayDtos = essayService.selectByAuthorId(authorId);
        if (ObjectUtils.isNotEmpty(essayDtos)) {
            return ResultVo.success(HttpStatus.STATUS_OK, BeanCloneUtils.clone(essayDtos,EssayDto.class, EssayVo.class));
        }
        return ResultVo.fail();
    }

    @GetMapping("/lists.json/{authorId}/{pageNum}/{pageSize}")
    public ResultVo listsByPage(@PathVariable Long authorId,@PathVariable Integer pageNum,@PathVariable Integer pageSize) {
        log.info("Controller layer: EssayController.listsByPage({},{},{})", authorId,pageNum,pageSize);
        Assert.notNull(authorId,"查询作者为空");
        Page<EssayDto> essayDtosPage = essayService.selectByAuthorIdPage(authorId,pageNum,pageSize);
        if (ObjectUtils.isNotEmpty(essayDtosPage.getRecords())) {
            return ResultVo.success(HttpStatus.STATUS_OK,essayDtosPage);
        }
        return ResultVo.fail();
    }



}
