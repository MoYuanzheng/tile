package com.mo.tile.controller;


import com.mo.tile.entity.User;
import com.mo.tile.service.impl.TokenServiceImpl;
import com.mo.tile.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * @author Naruto
 */
@Controller
public class LoginController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private TokenServiceImpl tokenService;

    /**
     * 重 定 向 至 前 端 登 录 页 面
     */
    @GetMapping(value = {"toLogin"})
    public String toLogin() {
        return "redirect:http://localhost:63343/1/index.html";
    }

    @ResponseBody
    @GetMapping(value = {"/"})
    public String index() {
        return "欢迎来到追溯系统";
    }

    /**
     * 跳 转 至 个 人 信 息
     */
    @ResponseBody
    @GetMapping(value = {"profile"})
    public User login() {
        return userService.getUserInfo();
    }

    /**
     * 注 册
     * Register
     */
    @ResponseBody
    @PostMapping("reg")
    public Boolean reg(@RequestParam("id") String id,
                       @RequestParam("username") String username,
                       @RequestParam("pwd") String pwd,
                       @RequestParam("roles") String roles,
                       @RequestParam("phone") String phone,
                       @RequestParam("email") String email,
                       @RequestParam("remarks") String remarks
    ) {
        User user = new User(
                id,
                username,
                pwd,
                roles,
                phone,
                email,
                remarks
        );

        return userService.register(user);
    }

    @GetMapping("setToken")
    @ResponseBody
    public String setToken() {
        return tokenService.setNewToken();
    }

    /**
     * 拿 到 Token
     */
    @GetMapping("getToken")
    @ResponseBody
    public String getToken() {
        return tokenService.getToken();
    }

}
