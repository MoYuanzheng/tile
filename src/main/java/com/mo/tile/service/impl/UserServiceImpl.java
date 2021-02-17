package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.User;
import com.mo.tile.mapper.UserMapper;
import com.mo.tile.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

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

    /**
     * 添 加 用 户
     */
    @Override
    public Boolean add(User user) {
        if (user != null) {
            String id = user.getId();
            return userMapper.selectById(id) == null && tokenService.setRegToken(id) && userMapper.insert(user) == 1;
        } else {
            return false;
        }
    }

    /**
     * 获 取 已 登 录 的 用 户 信 息
     */
    @Override
    public User getLoggedUserInfo() {

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
     * 修 改
     */
    @Override
    public Boolean update(User user) {
        return userMapper.updateById(user) == 1;
    }

    /**
     * 删 除 单 个
     */
    @Override
    public Boolean del(String id) {
        return userMapper.deleteById(id) == 1;
    }

    /**
     * 展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询
     */
    @Override
    public Page<User> query(Integer pages, String key) {
        Page<User> page = new Page<>(pages, 10);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("username", key).or()
                .like("roles", key).or()
                .like("phone", key)
                .like("email", key)
                .like("remark", key);
        userMapper.selectPage(page, wrapper);
        return page;
    }

    /**
     * 通过手机号找人
     */
    @Override
    public User getUseByPhone(String phoneNum) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", phoneNum);
        user = userMapper.selectOne(wrapper);
        return user;
    }

    /**
     * 检查时间是否小于一分钟
     * 小于一分钟 返回 true
     */
    @Override
    public Boolean checkTime(String phone) {
        Date time = new Date();
        //截至时间 <= 现在时间 + 60
        System.out.println(time);
        User user = getUseByPhone(phone);
        return user.getDeadline().getTime() <= new Date(time.getTime() + 60 * 1000).getTime();
    }

    /**
     * 更 新 校 验 码
     */
    @Override
    public Boolean updateSms(String phone, String code) {
        Date time = new Date();
        User user = getUseByPhone(phone);
        user.setDeadline(new Date(time.getTime() + 5 * 60 * 1000));
        user.setCode(code);
        return userMapper.updateById(user) == 1;
    }

    /**
     * 生 成 新 code
     */
    @Override
    public String smsCode() {
        return UUID.randomUUID().toString().substring(0, 4);
    }

    /**
     * 检查该手机号是否已注册
     * 真 为 注册
     * 假 为 未注册
     */
    @Override
    public Boolean isEmptyPhone(String phone) {
        return getUseByPhone(phone) != null;
    }
}