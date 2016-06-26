package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyong on 2016/6/26.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("welcome", "<h3>welcome,index....</h3>");
        return "index";
    }

}
