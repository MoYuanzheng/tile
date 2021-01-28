package com.mo.tile.config;
/**
 * @author: MoYz
 * @description:
 * @data: 2021/1/28
 */

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Moyz
 * @description MyBatisPlus配置
 */
@MapperScan("com.mo.tile.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
public class MyBatisPlusConfig {

    /**
     * 注 册 乐 观 锁 插 件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
