package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Sms;

/**
 * (Sms)表服务接口
 *
 * @author MoYz
 * @since 2021-02-15 13:43:55
 */
public interface SmsService extends IService<Sms> {
    /**
     * 添 加 操 作
     *
     * @param sms -> Sms实例
     * @return bool
     * @author Moyz
     * @date 2021-02-15 13:43:55
     */
    Boolean addSms(Sms sms);

    /**
     * 修 改 操 作
     *
     * @param sms -> Sms实例
     * @return bool
     * @author Moyz
     * @date 2021-02-15 13:43:55
     */
    Boolean updateSms(Sms sms);

    /**
     * 查 询 有 无 此 手 机 号
     *
     * @param phoneNum -> 电话
     * @return Boolean
     * @author Moyz
     * @date 2021/02/15 13:53
     */
    Boolean isEmptyPhone(String phoneNum);

    /**
     * 生 成 校 验 码
     *
     * @return String
     * @author Moyz
     * @date 2021/02/15 14:02
     */
    String smsCode();

    /**
     * 发 送 短 息 业 务
     *
     * @param phoneNum -> 接受的手机号码
     * @param code     -> 验证码
     * @return Boolean
     * @author Moyz
     * @date 2021/02/15 13:48
     */
    Boolean sendSmsCode(String phoneNum, String code);

    /**
     * 检查时间是否小于一分钟
     *
     * @param phoneNum -> 电话号码 主键
     * @return bool
     * @author Moyz
     * @date 2021/02/15 14:20
     */
    Boolean checkTime(String phoneNum);

    /**
     * 校 验 验 证 码
     *
     * @param phoneNum ->手机号
     * @param userCode ->验证码
     * @return Boolean
     * @author Moyz
     * @date 2021/02/15 20:38
     */
    String checkCode(String phoneNum, String userCode);
}