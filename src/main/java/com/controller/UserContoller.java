package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wy33082 on 16-6-24.
 */
@RestController
public class UserContoller {

    @RequestMapping("/user")
    public String user() {
        return "welcome,user...";
    }

    @RequestMapping("/")
    public String welcome(){
        return  "<h3>welcome....</h3>";
    }
}
