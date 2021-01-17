package com.mo.tile.controller;


import com.mo.tile.bean.Users;
import com.mo.tile.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    //模 拟 注 册 数 据
    Users user = new Users(
            "9999",
            "大马猴",
            "9999",
            1,
            "18888888888",
            "815687789@qq.com",
            "Test Insert");
    @Autowired
    private UsersServiceImpl usersServiceImpl;



    /*
     * 登 录 验 证
     * */
//    @ResponseBody
//    @GetMapping(value = {"/login"})
//    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
//        return usersServiceImpl.login(id, pwd);
//    }

    //@ResponseBody
    @GetMapping(value = {"/tologin"})
    public String toLogin() {
        return "redirect:http://localhost:63343/1/index.html";
    }

    @ResponseBody
    @GetMapping(value = {"/"})
    public String login() {
        return "I AM INDEX";
    }

    @ResponseBody
    @GetMapping(value = {"/logout"})
    public String logout() {
        return "logout success";
    }

    /*
     * 注 册
     * Register
     * */
    @ResponseBody
    @GetMapping("/reg")
    public Boolean reg() {
        return usersServiceImpl.register(user);
    }

}
