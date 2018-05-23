package com.dlsjy.dxzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:31
 * @Description
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index.html"})
    public String index() {
        return "index";
    }

}
