package com.mo.tile.config;


import com.mo.tile.service.MyUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author Naruto
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyUserDetailsServiceImpl myUserDetailsService;

    /*
    * 密 码 加 密
    * 数 据 库 对 应 加 密 存 储
    *
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    */

    /**
     * 密 码 取 消 加 密
     * 数 据 库 明 文
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 授 权 规 则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/toLogin").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/reg").permitAll()
                .antMatchers("/token/**").hasRole("admin")
                .antMatchers("/product/**").hasRole("user,admin")
                .antMatchers("/profile").authenticated();

        /**
         * 没 有 权 限 返 回 登 录 页
         * */
        http.formLogin()
                .loginPage("/toLogin")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/profile");

        /**
         * Cross—Site Request Forgery
         * 关 闭 跨 站 点 请 求 伪 造
         * */
        http.csrf().disable();

        /**
         * 开 启 注 销 功 能
         * */
        http.logout().logoutSuccessUrl("/");

        /*
         * 开 启 Remember Me
         * */
        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * 认 证 规 则
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
