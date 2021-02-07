package com.mo.tile.controller;


import com.mo.tile.entity.User;
import com.mo.tile.service.impl.TokenServiceImpl;
import com.mo.tile.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    UserServiceImpl userService;

    @Resource
    TokenServiceImpl tokenService;

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


    @ResponseBody
    @PostMapping("reg")
    @ApiOperation(value = "注册 Register", notes = "接收注册信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "string"),
            @ApiImplicitParam(name = "roles", value = "身份", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "phone", value = "电话号码", required = true, dataType = "string"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "E-mail"),
            @ApiImplicitParam(name = "remarks", value = "备注", dataType = "string")
    })
    public Boolean reg(@RequestParam("id") String id,
                       @RequestParam("username") String username,
                       @RequestParam("pwd") String pwd,
                       @RequestParam("roles") String roles,
                       @RequestParam("phone") String phone,
                       @RequestParam("email") String email,
                       @RequestParam("remarks") String remarks
    ) {
        return userService.register(new User(
                id,
                username,
                pwd,
                roles,
                phone,
                email,
                remarks
        ));
    }

    @ResponseBody
    @GetMapping("setToken")
    public String setToken() {
        return tokenService.setNewToken();
    }

    /**
     * 拿 到 Token
     */
    @ResponseBody
    @GetMapping("getToken")
    public String getToken() {
        return tokenService.getToken();
    }

}
