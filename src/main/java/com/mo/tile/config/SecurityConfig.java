package com.mo.tile.config;


import com.mo.tile.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    /*
     * 密 码 取 消 加 密
     * */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*
     * 认 证 规 则
     * */

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
                .antMatchers("/data").hasRole("admin")
                .antMatchers("/get").hasRole("user");
        /*
         * 没 有 权 限 返 回 登 录 页
         * */
        http.formLogin()
                .loginPage("/tologin")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/");

        /*
         * Cross—Site Request Forgery
         * 关 闭 跨 站 点 请 求 伪 造
         * */
        http.csrf().disable();

        /*
         * 开 启 注 销 功 能
         * */
        http.logout().logoutSuccessUrl("/");

        /*
         * 开 启  Remember Me
         * */
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    /*
     * 从 内 存 读 取 账 号 密 码 方 式

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("8888")
                .password(bCryptPasswordEncoder().encode("8888"))
                .authorities("admin");
    }
    * */
}
