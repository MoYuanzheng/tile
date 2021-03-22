package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.User;
import com.mo.tile.service.impl.SmsServiceImpl;
import com.mo.tile.service.impl.UserServiceImpl;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author MoYz
 */
@Api(tags = "登录相关")
@Controller
public class LoginController {

    @Resource
    UserServiceImpl userService;

    @Resource
    SmsServiceImpl smsService;

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
    public Map<String, String> add(
            @RequestParam("id") String id,
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
    public Map<String, String> del(@RequestParam("id") String id) {

        return userService.del(id);
    }

    /**
     * 展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询
     */
    @ApiOperation("展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询")
    @ResponseBody
    @GetMapping("query")
    public Page<User> query(
            @RequestParam("key") String key,
            @RequestParam("page") Integer page
    ) {
        return userService.query(page, key);
    }


    /**
     * 用 户 登 录 时 获 取 验 证 码
     *
     * @author Moyz
     * @date 2021/02/15 15:10
     */
    @ApiOperation("新增或更新验证码表")
    @GetMapping("sentSmsCode")
    @ResponseBody
    public String sentSmsCode(@RequestParam("phone") String phone) {
        /*
         * 0. 先查询有无此手机号，无手机号则令其注册
         * 1. 去数据库查询是否已存在验证码(若验证码生成小于1分钟则不生成新的)
         * 2. 若存在则返回 false , 若成功则进行下一步
         * 3. 生成验证码并存到数据库，设置生效时间
         * 4. 调用 SendSmsImpl 进行发送
         * */

        if (userService.isEmptyPhone(phone)) {
            //判断时间小于一分钟就更新
            if (userService.checkTime(phone)) {
                //更新校验码
                Boolean flag1 = userService.updateSms(phone, userService.smsCode());
                //发送校验码
                Boolean flag2 = smsService.sendSmsCode(phone, userService.getUseByPhone(phone).getCode());
                if (flag1 && flag2) {
                    return "已成功发送效验码，请查收！";
                } else {
                    return "未知错误！";
                }
            } else {
                return "禁止频繁发送验证码！";
            }
        } else {
            return "未查询到该用户，请注册后登录！";
        }
    }
}
