package com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
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

    @RequestMapping("/login")
    public String login(String username, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {

        }

        return null;
    }


}
