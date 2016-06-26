package com.configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * mybatis配置
 * Created by wangyong on 2016/6/26.
 */
@Component
@ConfigurationProperties(prefix = "mybatis")
public class MybatisConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSouce() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", environment.getProperty("jdbc.driverClassName"));
        props.put("url", environment.getProperty("jdbc.url"));
        props.put("username", environment.getProperty("jdbc.username"));
        props.put("password", environment.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

}
