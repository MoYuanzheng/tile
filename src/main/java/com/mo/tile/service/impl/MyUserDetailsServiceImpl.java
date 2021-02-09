package com.mo.tile.service.impl;


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
        String password = user.getPwd();
        String userId = user.getId();
        String role = user.getRoles();
        return new org.springframework.security.core.userdetails.User(userId, password, AuthorityUtils.commaSeparatedStringToAuthorityList(role));
    }
}


