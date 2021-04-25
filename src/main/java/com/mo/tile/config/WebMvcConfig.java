package com.mo.tile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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


}
