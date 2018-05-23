package com.solstice.melon.controller;

import com.alibaba.fastjson.JSON;
import com.base.enums.HttpStatus;
import com.google.common.collect.Lists;
import com.solstice.melon.annotations.CurrentUser;
import com.solstice.melon.controller.vo.EmployeeVo;
import com.solstice.melon.controller.vo.ResumeVo;
import com.solstice.melon.manager.IResumeManager;
import com.solstice.melon.service.dto.ResumeDto;
import com.solstice.melon.vo.Principal;
import com.summer.base.utils.BeanCloneUtils;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author yangyang
 * @Date 2018/5/23
 * @Time 16:58
 * @Description
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private IResumeManager resumeManager;

    @GetMapping("/info.json")
    public ResultVo info(@CurrentUser Principal employee) {
        log.info("Controller layer: EmployeeController.info({})", JSON.toJSONString(employee,true));
        Assert.notNull(employee,"你没有权限查看个人信息，请登录!");

        List<ResumeVo> resumeVos = Lists.newArrayList();
        EmployeeVo employeeVo = BeanCloneUtils.clone(employee, Principal.class, EmployeeVo.class);
        if (ObjectUtils.isNotNull(employeeVo)) {
            List<ResumeDto> resumeDtos = resumeManager.queryByUserId(employee.getId());
            if (ObjectUtils.isNotEmpty(resumeDtos)) {
                List<ResumeVo> resumeVos1 = BeanCloneUtils.deepClone(resumeDtos, ResumeDto.class, ResumeVo.class);
                log.info("ResumeVo={}",JSON.toJSONString(resumeVos1,true));
                resumeVos.addAll(resumeVos1);
            }
        }

        if (ObjectUtils.isNotEmpty(resumeVos)) {
            employeeVo.setResumeVos(resumeVos);
            return ResultVo.success(HttpStatus.STATUS_OK,employeeVo);
        }
        return ResultVo.fail();
    }

}
