package com.mo.tile.controller;

import com.mo.tile.entity.User;
import com.mo.tile.service.impl.TokenServiceImpl;
import com.mo.tile.service.impl.UserServiceImpl;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoYz
 */
@Api(tags = "登 录 相 关")
@Controller
public class LoginController {

    @Resource
    UserServiceImpl userService;

    @Resource
    TokenServiceImpl tokenService;

    /**
     * 重 定 向 至 前 端 登 录 页 面
     */
    @ApiOperation("重 定 向 至 前 端 登 录 界 面")
    @GetMapping(value = {"toLogin"})
    public String toLogin() {
        return "redirect:http://localhost:63343/1/index.html";
    }

    /**
     * 跳 转 至 主 页
     */
    @ApiOperation("跳 转 至 主 页")
    @ResponseBody
    @GetMapping(value = {"/"})
    public String index() {
        return "欢迎来到追溯系统";
    }

    /**
     * 跳 转 至 个 人 信 息
     */
    @ApiOperation("返 回 当 前 用 户 信 息")
    @ResponseBody
    @GetMapping(value = {"profile"})
    public User login() {
        return userService.getLoggedUserInfo();
    }


    /**
     * 注 册 账 号 / 新 增 用 户
     */
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
    @ResponseBody
    @PostMapping("reg")
    public Boolean add(@RequestParam("id") String id,
                       @RequestParam("username") String username,
                       @RequestParam("pwd") String pwd,
                       @RequestParam("roles") String roles,
                       @RequestParam("phone") String phone,
                       @RequestParam("email") String email,
                       @RequestParam("remark") String remark
    ) {
        return userService.add(new User(
                id,
                username,
                pwd,
                roles,
                phone,
                email,
                remark
        ));
    }

    /**
     * 修 改 个 人 信 息
     */
    @ApiOperation("修 改 个 人 信 息")
    @ResponseBody
    @PutMapping("getToken")
    public Boolean update(
            @RequestParam("id") @ApiParam("登录名") String id,
            @RequestParam("username") @ApiParam("用户名") String username,
            @RequestParam("pwd") @ApiParam("密码") String pwd,
            @RequestParam("roles") @ApiParam("权限") String roles,
            @RequestParam("phone") @ApiParam("电话号码") String phone,
            @RequestParam("email") @ApiParam("邮件") String email,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return userService.update(new User(
                id,
                username,
                pwd,
                roles,
                phone,
                email,
                remark
        ));
    }

    /**
     * 通 过 id 删 除 个 人 信 息
     */
    @ApiOperation("删 除 个 人 信 息")
    @ResponseBody
    @DeleteMapping("del")
    public Boolean del(@RequestParam("id") String id) {

        return userService.del(id);
    }

    /**
     * 展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询
     */
    @ApiOperation("展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询")
    @ResponseBody
    @GetMapping("query")
    public List<User> query(@RequestParam("key") String key) {
        return userService.query(key);
    }


    @ApiOperation("更 新 token")
    @ResponseBody
    @GetMapping("setToken")
    public String setToken() {
        return tokenService.setNewToken();
    }

    /**
     * 拿 到 Token
     */
    @ApiOperation("拿 到 Token")
    @ResponseBody
    @GetMapping("getToken")
    public String getToken() {
        return tokenService.getToken();
    }
}
