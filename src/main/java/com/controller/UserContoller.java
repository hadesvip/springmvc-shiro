package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wy33082 on 16-6-24.
 */
@RestController
public class UserContoller {

    @RequestMapping("/")
    public String hello() {
        return "hello,userContoller...";
    }


}
