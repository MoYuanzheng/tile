package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.User;

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
     * 修 改 备 用
     *
     * @param name -> 姓名
     * @return bool
     * @author Moyz
     * @date 2021/02/07 15:58
     */
    Boolean setName(String name);
}