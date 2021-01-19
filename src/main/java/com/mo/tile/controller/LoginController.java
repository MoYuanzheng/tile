package com.mo.tile.controller;


import com.mo.tile.bean.Users;
import com.mo.tile.service.impl.TokenServiceImpl;
import com.mo.tile.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {


    //模 拟 注 册 数 据
    Users user = new Users(
            "root",
            "小马猴",
            "root",
            "ROLE_admin",
            "18888888888",
            "88888888@gmail.com",
            "Test root");
    @Autowired
    private UsersServiceImpl usersService;
    @Autowired
    private TokenServiceImpl tokenService;

    /*
     * 重 定 向 至 前 端 登 录 页 面
     * */
    @GetMapping(value = {"/tologin"})
    public String toLogin() {
        return "redirect:http://localhost:63343/1/index.html";
    }

    @ResponseBody
    @GetMapping(value = {"/"})
    public String index() {
        return "欢迎来到追溯系统";
    }

    /*
     * 跳 转 至 个 人 信 息
     * */
    @ResponseBody
    @GetMapping(value = {"/profile"})
    public Users login() {
        return usersService.getUserInfo();
    }

    /*
     * 注 册
     * Register
     * */
    @ResponseBody
    @GetMapping("/reg")
    public Boolean reg() {
        return usersService.register(user);
    }

    @GetMapping("/setToken")
    @ResponseBody
    public String setToken() {
        return tokenService.setNewToken();
    }

    @GetMapping("/getToken")
    @ResponseBody
    public String getToken() {
        return tokenService.getToken();
    }

}
