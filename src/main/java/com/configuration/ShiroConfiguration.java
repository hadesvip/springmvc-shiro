package com.configuration;

import com.component.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

/**
 * shiro配置
 * Created by wy33082 on 16-6-24.
 */
@Configuration
public class ShiroConfiguration {

    /**
     * logging
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfiguration.class);


    /**
     * 注册shiroFilter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean shiroFilter() {
        LOGGER.info("register shiroFilter...");
        FilterRegistrationBean shiroFilterRegistion = new FilterRegistrationBean();
        shiroFilterRegistion.setFilter(new DelegatingFilterProxy("shiroFilter"));

        //交给servletContainer管理
        shiroFilterRegistion.addInitParameter("targetFilterLifecycle", "true");
        shiroFilterRegistion.setEnabled(true);
        shiroFilterRegistion.addUrlPatterns("/*");
        shiroFilterRegistion.setDispatcherTypes(DispatcherType.REQUEST);
        return shiroFilterRegistion;
    }

    @Bean(name = "shiroRealm")
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm);

        //添加subject
        //defaultWebSecurityManager.setSubjectFactory();
        return defaultWebSecurityManager;
    }

    /**
     * 登录配置
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //登录地址
        shiroFilterFactoryBean.setLoginUrl("/login");

        //登录成功跳转地址
        shiroFilterFactoryBean.setSuccessUrl("/user");


        return shiroFilterFactoryBean;
    }
}

