package com.mo.tile.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
                .antMatchers("/get").hasRole("1")
                .antMatchers("/data").hasRole("2");

        /*
         * 没 有 权 限 返 回 登 录 页
         * */
        http.formLogin()
                .loginPage("/tologin")
                .loginProcessingUrl("/login");

//        http.cors().disable();
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

    /**
     * 认 证 规 则
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("1", "2")
                .and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("2");
    }
}
