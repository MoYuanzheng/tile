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
 * @author Naruto
 */
@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 获 取 当 前 登 录 用 户 信 息
     */
    User user = new User();
    @Resource
    private UserMapper userMapper;

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
    public Boolean register(User user) {
        if (user != null) {
            String id = user.getId();
            return userMapper.selectById(id) == null && tokenService.setRegToken(id) && userMapper.insert(user) == 1;
        } else {
            return false;
        }
    }

    /**
     * 拿到已登录用户信息
     */
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

    /**
     * 留 作 修 改
     */
    public Boolean setName(String name) {
        User userToName;
        userToName = getUserInfo();
        userToName.setUsername(name);
        System.out.println(userToName);
        return userMapper.updateById(userToName) == 1;
    }
}