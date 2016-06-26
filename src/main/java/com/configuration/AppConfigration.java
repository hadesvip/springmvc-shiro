package com.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by wangyong on 2016/6/26.
 */
@Component
@MapperScan(basePackages = "com.mapper")
@ComponentScan(basePackages = "com")
public class AppConfigration {
}
