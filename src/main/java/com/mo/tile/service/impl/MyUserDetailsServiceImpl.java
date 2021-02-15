package com.mo.tile.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mo.tile.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登 录 验 证
 *
 * @author MoYz
 */
@Service
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    User user = new User();
    @Resource
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        user = userService.getById(id);
        String password;
        if (user == null) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("phone", id);
            user = userService.getOne(wrapper);
            //应验证是否过期
            if (user.getDeadline().getTime() <= System.currentTimeMillis()) {
                //若已过期，则赋一绝对错误值
                password = "-1";
            } else {
                password = user.getCode();
            }
        } else {
            password = user.getPwd();
        }

        String userId = user.getId();
        String role = user.getRoles();
        return new org.springframework.security.core.userdetails.User(userId, password, AuthorityUtils.commaSeparatedStringToAuthorityList(role));
    }
}


