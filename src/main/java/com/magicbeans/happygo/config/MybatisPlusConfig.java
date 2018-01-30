package com.magicbeans.happygo.config;

import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.CachePaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by jesus on 2017/7/10.
 */

@Configuration
@MapperScan(basePackages = "com.magicbeans.happygo.mapper")
@PropertySource({"classpath:database.properties"})
public class MybatisPlusConfig {

    @Bean
    public CachePaginationInterceptor paginationInterceptor() {
        CachePaginationInterceptor paginationInterceptor = new CachePaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        paginationInterceptor.setLocalPage(true);
        return paginationInterceptor;
    }




}