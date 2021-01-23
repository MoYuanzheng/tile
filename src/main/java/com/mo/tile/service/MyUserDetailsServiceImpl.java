package com.mo.tile.service;


import com.mo.tile.entity.User;
import com.mo.tile.service.impl.UserServiceImpl;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Naruto
 * @ImplName: MyUserDetailsServiceImpl
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
        System.out.println(user);
        String password = user.getPwd();
        String userId = user.getId();
        String role = user.getRoles();
        return new org.springframework.security.core.userdetails.User(userId, password, AuthorityUtils.commaSeparatedStringToAuthorityList(role));
    }
}


