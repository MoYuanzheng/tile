package com.mo.tile.controller;


import com.mo.tile.entity.Users;
import com.mo.tile.service.impl.TokenServiceImpl;
import com.mo.tile.service.impl.UsersServiceImpl;
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
    private UsersServiceImpl usersService;

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
     * */
    @ResponseBody
    @GetMapping(value = {"profile"})
    public Users login() {
        return usersService.getUserInfo();
    }

    /**
     * 注 册
     * Register
     * */
    @ResponseBody
    @PostMapping("reg")
    public Boolean reg(@RequestParam("user_id") String user_id,
                       @RequestParam("user_name") String user_name,
                       @RequestParam("user_password") String user_password,
                       @RequestParam("user_role") String user_role,
                       @RequestParam("user_phone") String user_phone,
                       @RequestParam("user_email") String user_email,
                       @RequestParam("user_remarks") String user_remarks
    ) {
        Users user = new Users(
                user_id,
                user_name,
                user_password,
                user_role,
                user_phone,
                user_email,
                user_remarks
        );

        return usersService.register(user);
    }

    @GetMapping("setToken")
    @ResponseBody
    public String setToken() {
        return tokenService.setNewToken();
    }

    /**
     * 拿 到 Token
     * ============================================
     *
     * @className: getToken
     * @return: String
     * ===========================================
     */
    @GetMapping("getToken")
    @ResponseBody
    public String getToken() {
        return tokenService.getToken();
    }

}
