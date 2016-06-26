package com.configuration;

import com.component.ShiroRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

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
    public FilterRegistrationBean registershiroFilter() {
        LOGGER.info("register shiroFilter...");
        FilterRegistrationBean shiroFilterRegistion = new FilterRegistrationBean();
        shiroFilterRegistion.setFilter(new DelegatingFilterProxy("shiroFilter"));

        //交给servletContainer管理
        shiroFilterRegistion.addInitParameter("targetFilterLifecycle", "true");
        shiroFilterRegistion.setEnabled(true);
        shiroFilterRegistion.addUrlPatterns("/*");
        EnumSet dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        shiroFilterRegistion.setDispatcherTypes(dispatcherTypes);
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

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }


    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(LifecycleBeanPostProcessor lifecycleBeanPostProcessor) {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;


    }

    /**
     * 登录配置
     *
     * @param securityManager 安全管理
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //登录地址
        shiroFilterFactoryBean.setLoginUrl("/login.html");

        //无权限访问页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthority.html");

        //登录成功跳转地址
        shiroFilterFactoryBean.setSuccessUrl("/user");

        //TODO 加载用户角色对应的资源
        loadUserAuthority(shiroFilterFactoryBean);

        return shiroFilterFactoryBean;
    }


    /**
     * 加载用户资源
     */
    public void loadUserAuthority(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        Map<String, String> userAuthorityMap = new HashMap<>();
        userAuthorityMap.put("/user", "authc");
        userAuthorityMap.put("/login.html", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(userAuthorityMap);
    }
}
