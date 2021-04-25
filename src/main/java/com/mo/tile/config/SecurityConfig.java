package com.mo.tile.config;

import com.mo.tile.service.impl.MyUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author MoYz
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Resource
    private JwtAuthTokenFilter jwtAuthTokenFilter;
    /**
     * 密 码 加 密
     * 数 据 库 对 应 加 密 存 储
     *
     * @Bean
     * public BCryptPasswordEncoder bCryptPasswordEncoder(){
     *   return new BCryptPasswordEncoder();
     * }
     */

    /**
     * 密 码 取 消 加 密
     * 数 据 库 明 文

     @Bean public PasswordEncoder bCryptPasswordEncoder() {
     return NoOpPasswordEncoder.getInstance();
     }*/

    /**
     * 授 权 规 则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().
                sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/toLogin").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/reg").permitAll()
                .antMatchers("/trace").permitAll()
                .antMatchers("/batch").permitAll()
                .antMatchers("/sentSmsCode").permitAll()
                .antMatchers("/container/**").hasRole("ADMIN")
                .antMatchers("/profile").hasRole("ADMIN");

        /**
         * 没 有 权 限 返 回 登 录 页
         */
//        http.formLogin()
        //.loginPage("/toLogin")
//                .loginProcessingUrl("/login");
        //.defaultSuccessUrl("/profile")
        //.successHandler(new MyAuthenticationSuccessHandler("/profile"))
        //.failureForwardUrl("/toError")
        //.failureHandler(new MyAuthenticationFailureHandler("http://localhost:63342/X-admin-v2.2/X-admin/login.html?error=true"));
        /**
         * Cross—Site Request Forgery
         * 关 闭 跨 站 点 C S R F  攻 击 防 御
         * 开 启 后 无 法 登 录
         */
        http.csrf().disable();

        /**
         * 开 启 注 销 功 能
         */
        http.logout().logoutSuccessUrl("/");

        /**
         * 开 启 Remember Me
         */
        http.rememberMe().rememberMeParameter("remember");

        //  添加JWT  filter, 在每次http请求前进行拦截
        http.addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 认 证 规 则
     * <p>
     * protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     * auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
     * }
     */

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //调用DetailsService完成用户身份验证              设置密码加密方式
        auth.userDetailsService(myUserDetailsService).passwordEncoder(getBCryptPasswordEncoder());
    }

    // 在通过数据库验证登录的方式中不需要配置此种密码加密方式, 因为已经在JWT配置中指定
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
