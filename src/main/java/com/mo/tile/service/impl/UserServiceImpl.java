package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.common.RestResult;
import com.mo.tile.entity.User;
import com.mo.tile.mapper.UserMapper;
import com.mo.tile.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private UserService userService;

    /**
     * 添 加 用 户
     */
    @Override
    public RestResult add(User user) {
        RestResult result = RestResult.newInstance();
        //判断用户信息不为空
        if (user != null) {
            //加密
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPwd(passwordEncoder.encode(user.getPassword()));
            //判断数据库有该用户名以及手机号
            if (selectUserByUserName(user.getUsername()) != null) {
                result.setMsg("FAIL");
                result.setCode(400);
                result.setData("该用户名已被使用");
            } else if (getUserByPhone(user.getPhone()) != null) {
                result.setMsg("FAIL");
                result.setCode(400);
                result.setData("该手机号已被使用");
            } else {
                //若成功插入
                if (userMapper.insert(user) == 1) {
                    result.setCode(200);
                    result.setMsg("OK");
                } else {
                    result.setCode(400);
                    result.setMsg("FAIL");
                    result.setMsg("Creation failed, please try again.[Deleted username is not available]");
                }
            }
        } else {
            result.setMsg("FAIL");
            result.setCode(400);
            result.setData("必填字段不得为空");
        }
        return result;
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
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        user = userService.selectUserByUserName(username);
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
     * 通 过 手 机 号 找 人
     */
    @Override
    public User getUserByPhone(String phoneNum) {
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
        User user = getUserByPhone(phone);
        return user.getDeadline().getTime() <= new Date(time.getTime() + 60 * 1000).getTime();
    }

    /**
     * 更 新 校 验 码
     */
    @Override
    public Boolean updateSms(String phone, String code) {
        Date time = new Date();
        User user = getUserByPhone(phone);
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
        return getUserByPhone(phone) != null;
    }

    /**
     * JWT鉴权专用
     * 通过登录名获取用户信息
     */
    @Override
    public User selectUserByUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }
}