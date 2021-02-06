package com.mo.tile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Moyz
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配 置 Swagger 的 Docket 的 Bean 实 例
     */
    @Bean
    public Docket docket(Environment environment) {

        /**
         * 判 断 生 产 环 境，非 生 产 环 境 swagger 不 启 用
         */
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        /**
         * Api 文 档 的 描 述 信 息
         */
        ApiInfo apiInfo = new ApiInfoBuilder()
                .contact(
                        new Contact(
                                "莫远征",
                                "http://www.baidu.com",
                                "MoYuanzheng@gmail.com")
                )
                .title("API 说明文档")
                .description("追溯系统")
                .version("1.0")
                .build();
        docket
                .groupName("MoYz")
                .apiInfo(apiInfo)
                .enable(flag)
                .select()
                /**
                 * any() : 扫 描 全 部
                 * none() ：不 扫 描
                 * withClassAnnotation() : 扫 描 类 上 的 注 解
                 * withMethodAnnotation(GetMapping.class) : 扫 描 方 法 上 的 注 解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.mo.tile.controller"))
                /**
                 * 过 滤 路 径
                 * paths(PathSelectors.ant("com.mo.**"))
                 */
                .build();
        return docket;
    }
}
