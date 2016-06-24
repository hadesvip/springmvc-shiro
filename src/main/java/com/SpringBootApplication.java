package com;

import com.controller.UserContoller;
import org.springframework.boot.SpringApplication;

/** 程序入口
 * Created by wy33082 on 16-6-24.
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        Class[] contorllerArray = new Class[]{SpringBootApplication.class, UserContoller.class};

        SpringApplication.run(contorllerArray,args);
    }

}
