package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author MoYz
 * @since 2021-01-23 15:32:40
 */
public interface UserService extends IService<User> {
    /**
     * 注 册
     *
     * @param user -> user 对象
     * @return bool
     * @author Moyz
     * @date 2021/02/07 15:59
     */
    Boolean add(User user);

    /**
     * 修 改 用 户 信 息
     *
     * @param user -> 用户对象
     * @return bool
     * @author Moyz
     * @date 2021/02/08 18:07
     */
    Boolean update(User user);

    /**
     * 逻 辑 删 除 用 户 信 息
     *
     * @param id -> 用户主键
     * @return bool
     * @author Moyz
     * @date 2021/02/08 18:20
     */
    Boolean del(String id);

    /**
     * 拿 到 已 登 录 用 户 信 息
     *
     * @return User
     * @author Moyz
     * @date 2021/02/07 15:57
     */
    User getLoggedUserInfo();

    /**
     * 展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询
     *
     * @param key -> 关键字
     * @return List<User></>用户列表
     * @author Moyz
     * @date 2021/02/08 18:29
     */
    List<User> query(String key);

    /**
     * 通过手机号找人
     *
     * @param phone -> 手机号
     * @return User
     * @author Moyz
     * @date 2021/02/16 00:29
     */
    User getUseByPhone(String phone);

    /**
     * 检查时间是否小于一分钟
     *
     * @param phone -> 电话号码 主键
     * @return bool
     * @author Moyz
     * @date 2021/02/15 14:20
     */
    Boolean checkTime(String phone);

    /**
     * 发 送 短 息 业 务
     *
     * @param phone -> 接受的手机号码
     * @param code  -> 验证码
     * @return Boolean
     * @author Moyz
     * @date 2021/02/15 13:48
     */
    Boolean sendSmsCode(String phone, String code);

    /**
     * 生 成 校 验 码
     *
     * @return String
     * @author Moyz
     * @date 2021/02/15 14:02
     */
    String smsCode();

    /**
     * 添 加 操 作
     *
     * @param phone -> 手机号
     * @param code  -> 验证码
     * @return bool
     * @author Moyz
     * @date 2021-02-15 13:43:55
     */
    Boolean updateSms(String phone, String code);

    /**
     * 检查该手机号是否已注册
     *
     * @param phone -> 手机号
     * @return bool
     * @author Moyz
     * @date 2021/02/16 00:45
     */
    Boolean isEmptyPhone(String phone);

}