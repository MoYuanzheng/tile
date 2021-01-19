package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.bean.Token;
import com.mo.tile.mapper.TokenMapper;
import com.mo.tile.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private TokenServiceImpl tokenService;

    /*
     * 判 断 token 是 否 合 法
     * */
    public Boolean isToken(String uuid) {
        //获 取 登 录 用 户 ID 并 据 此 ID 获 取 Token 与 终 止 时 间
        if (usersService.getUserInfo() != null) {
            String id = usersService.getUserInfo().getUser_id();
            String token = tokenService.getById(id).getToken();
            Long token_time = tokenService.getById(id).getToken_time();
            long time_now = new Date().getTime() / 1000;

            if (time_now >= token_time) {
                return false;
            } else {
                return uuid.equals(token);
            }
        } else {
            return false;
        }
    }

    /*
     * 设 置 Token , 每 次 登 录 刷 新 Token
     * */
    public String setNewToken() {
        if (usersService.getUserInfo() != null) {
            String newToken = String.valueOf(UUID.randomUUID());
            String id = usersService.getUserInfo().getUser_id();
            Long time = new Date().getTime() / 1000 + (30 + 60);

            Token token = new Token(id, newToken, time);
            System.out.println(token);

            if (tokenService.saveOrUpdate(token))
                return newToken;
            else return "false";
        } else {
            return "false";
        }
    }

    /*
     * 得 到 Token
     * */
    public String getToken() {
        if (usersService.getUserInfo() != null) {
            String id = usersService.getUserInfo().getUser_id();
            Token token = tokenService.getById(id);
            return token.getToken();
        } else {
            return "false";
        }
    }
}