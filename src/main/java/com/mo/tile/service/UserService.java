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
    Boolean register(User user);

    /**
     * 拿 到 已 登 录 用 户 信 息
     *
     * @return User
     * @author Moyz
     * @date 2021/02/07 15:57
     */
    User getUserInfo();

    /**
     * 修 改 用 户 信 息
     *
     * @param user -> 用户对象
     * @return bool
     * @author Moyz
     * @date 2021/02/08 18:07
     */
    Boolean updateUserInfo(User user);

    /**
     * 逻 辑 删 除 用 户 信 息
     *
     * @param id -> 用户主键
     * @return bool
     * @author Moyz
     * @date 2021/02/08 18:20
     */
    Boolean deleteUserInfo(String id);

    /**
     * 展 示 用 户 列 表 / 查 询 用 户 / 模 糊 查 询
     *
     * @param key -> 关键字
     * @return List<User></>用户列表
     * @author Moyz
     * @date 2021/02/08 18:29
     */
    List<User> showListUserInfo(String key);
}