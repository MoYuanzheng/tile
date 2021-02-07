package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.User;
import com.mo.tile.mapper.UserMapper;
import com.mo.tile.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MoYz
 */
@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    User user;
    @Resource
    private UserMapper userMapper;

    @Resource
    private TokenServiceImpl tokenService;

    @Override
    public Boolean register(User user) {
        if (user != null) {
            String id = user.getId();
            return userMapper.selectById(id) == null && tokenService.setRegToken(id) && userMapper.insert(user) == 1;
        } else {
            return false;
        }
    }

    @Override
    public User getUserInfo() {
        // 从 容 器 中 取 得 已 登 录 的 用 户
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

        user = userMapper.selectById(id);
        return user;
    }

    @Override
    public Boolean setName(String name) {
        user.setUsername(name);
        System.out.println(user);
        return userMapper.updateById(user) == 1;
    }
}