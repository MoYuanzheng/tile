package com.mo.tile.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.List;
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

    @Override
    public Boolean add(User user) {
        if (user != null) {
            String id = user.getId();
            return userMapper.selectById(id) == null && tokenService.setRegToken(id) && userMapper.insert(user) == 1;
        } else {
            return false;
        }
    }

    @Override
    public User getLoggedUserInfo() {
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
    public Boolean update(User user) {
        return userMapper.updateById(user) == 1;
    }

    @Override
    public Boolean del(String id) {
        return userMapper.deleteById(id) == 1;
    }

    @Override
    public List<User> query(String key) {
        return null;
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
     * 发 送 code
     */
    @Override
    public Boolean sendSmsCode(String phone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GKq7haEzq8ZUDrfDLD1", "4L6QmWjFE5bmyeEWeaWJqefFGkaIZY");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");

        /**
         * 自 定 义 参 数
         */
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "商品信息追溯系统");
        request.putQueryParameter("TemplateCode", "TemplateCode");
        request.putQueryParameter("TemplateParam", code);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
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