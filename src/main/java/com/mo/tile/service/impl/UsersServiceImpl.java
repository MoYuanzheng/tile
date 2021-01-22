package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Users;
import com.mo.tile.mapper.UsersMapper;
import com.mo.tile.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Naruto
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    /**
     * 获 取 当 前 登 录 用 户 信 息
     */
    Users user = new Users();
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private UsersServiceImpl usersService;

    /**
     * 分 页 查 询 业 务
     */
    @Resource
    private TokenServiceImpl tokenService;

    /**
     * 登 录 业 务 ( 已 交 给 Spring Security 完 成  )
     * */

    /**
     * 注 册 业 务
     */
    public Boolean register(Users user) {

        if (user != null) {
            String id = user.getUser_id();
            return usersMapper.selectById(id) == null && tokenService.setRegToken(id) && usersMapper.insert(user) == 1;
        } else {
            return false;
        }
    }

    public Users getUserInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        String id;
        if (principal instanceof UserDetails) {
            id = ((UserDetails) principal).getUsername();
        } else {
            id = principal.toString();
        }

        user = usersMapper.selectById(id);
        return user;
    }
}