package com.mo.tile.service;


import com.mo.tile.bean.Users;
import com.mo.tile.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Users user = usersMapper.selectById(id);
        String password = user.getUser_password();
        String user_id = user.getUser_id();
        String role = user.getUser_role();

        return new User(user_id, password, AuthorityUtils.commaSeparatedStringToAuthorityList(role));
    }
}


