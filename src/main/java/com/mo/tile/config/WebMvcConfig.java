package com.mo.tile.config;

import com.mo.tile.interceptor.IndexInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author Naruto
 */
@Configuration
@EnableWebSecurity
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 跨 域 处 理
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:63343")
                //允许的header
                .allowedHeaders("*")

                //允许的方法
                .allowedMethods("*")

                //put探测请求有效期
                .maxAge(3600);
    }

    /**
     * 拦 截 器 设 置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IndexInterceptor())
                //被拦截的  拦截所有 /**
                .addPathPatterns("")
                //放行的
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");
    }

}
