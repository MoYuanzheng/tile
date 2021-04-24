package com.mo.tile.service.impl;

import com.mo.tile.entity.User;
import com.mo.tile.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * asd
 *
 * @author Moyz
 * @date 2021/04/23 17:05
 */
@Service
public class JwtAuthService {

    // 此处注入的bean在SpringConfig中产生, 如果不在其中声明则注入AuthenticationManager报错
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    /**
     * 登录认证换取JWT令牌
     *
     * @param username
     * @param password
     * @return
     */
    public String login(String username, String password) {
        //用户验证
        Authentication authentication = null;
        try {
            // 进行身份验证,
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new RuntimeException("用户名密码错误");
        }

        User loginUser = (User) authentication.getPrincipal();
        // 生成token
        return jwtTokenUtils.generateToken(loginUser);

    }

}
