package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Token;
import com.mo.tile.mapper.TokenMapper;
import com.mo.tile.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * (Token)表服务实现类
 *
 * @author mo
 * @since 2021-01-22 00:20:09
 */
@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {
    /**
     * 分页查询
     */
    @Resource
    private TokenMapper tokenMapper;

    @Resource
    private UserServiceImpl usersService;

    @Resource
    private TokenServiceImpl tokenService;

    public Page<Token> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Token> page = new Page<>(pages, 10);
        tokenMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }

    /**
     * 判 断 token 是 否 合 法
     */
    public Boolean isToken(String uuid) {
        //获 取 登 录 用 户 ID 并 据 此 ID 获 取 Token 与 终 止 时 间
        if (usersService.getUserInfo() != null) {
            String id = usersService.getUserInfo().getId();
            String token = tokenService.getById(id).getToken();
            Integer tokenDeadline = tokenService.getById(id).getDeadline();
            Integer timeNow = Math.toIntExact(System.currentTimeMillis() / 1000);

            if (timeNow >= tokenDeadline) {
                return false;
            } else {
                return uuid.equals(token);
            }
        } else {
            return false;
        }
    }

    /**
     * 设 置 Token , 每 次 登 录 刷 新 Token
     */
    public String setNewToken() {
        if (usersService.getUserInfo() != null) {
            String newToken = String.valueOf(UUID.randomUUID());
            String id = usersService.getUserInfo().getId();
            Integer time = Math.toIntExact(System.currentTimeMillis() / 1000 + (30 + 60));

            Token token = new Token(id, newToken, time);
            System.out.println(token);

            if (tokenService.saveOrUpdate(token)) {
                return newToken;
            } else {
                return "false";
            }
        } else {
            return "false";
        }
    }

    /**
     * 注 册 时 设 置 Token
     */
    public Boolean setRegToken(String id) {
        if (id != null) {
            String newToken = String.valueOf(UUID.randomUUID());
            Integer time = Math.toIntExact(System.currentTimeMillis() / 1000 + (30 + 60));
            Token token = new Token(id, newToken, time);
            return tokenService.saveOrUpdate(token);
        }
        return false;
    }

    /**
     * 得 到 token
     */
    public String getToken() {
        if (usersService.getUserInfo() != null) {
            String id = usersService.getUserInfo().getId();
            Token token = tokenService.getById(id);
            return token.getToken();
        } else {
            return "false";
        }
    }
}