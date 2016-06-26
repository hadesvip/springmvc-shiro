package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户层
 * Created by wy33082 on 16-6-24.
 */
@RestController
public class UserContoller {

    @RequestMapping("/user")
    public String user() {
        return "welcome,user...";
    }


}
