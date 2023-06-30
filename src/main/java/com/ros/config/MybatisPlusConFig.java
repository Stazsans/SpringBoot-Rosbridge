package com.ros.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Springboot整合MybatisPlus配置类
 * @author ss
 */
@Configuration
@MapperScan("com.ros.mapper")
public class MybatisPlusConFig {
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }
}
