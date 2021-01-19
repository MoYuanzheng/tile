package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.bean.Users;
import com.mo.tile.mapper.UsersMapper;
import com.mo.tile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /*
     * 分 页 查 询 业 务
     * */

    /*
     * 注 册 业 务
     * */
    public Boolean register(Users user) {
        if (user != null) {
            String id = user.getUser_id();
            if (usersMapper.selectById(id) == null) {
                usersMapper.insert(user);
                return true;
            } else return false;
        } else return false;
    }

    /*
     * 登 录 业 务
     * */
    public String login(String id, String pwd) {
        boolean flag = usersMapper.selectById(id).getUser_password().equals(pwd);
        if (flag) {
            /*
             * 设置token
             * */
            return "token";
        } else {
            return "error";
        }
    }


}