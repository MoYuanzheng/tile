package com.mo.tile.controller;/**
 * @author: MoYz
 * @description:
 * @data: 2021/2/14
 */

import com.mo.tile.entity.Sms;
import com.mo.tile.service.impl.SmsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 注 册 时 验 证 码
 *
 * @author Moyz
 * @date 2021/02/14 23:31
 */
@Api(tags = "注册时临时用户，短信验证码相关")
@RestController
@RequestMapping("Sms")
public class SmsController {

    /**
     * 核对验证码结果返回值
     */
    static final String RESULT = "success";

    @Resource
    private SmsServiceImpl smsService;

    /**
     * 用 户 获 取 验 证 码
     *
     * @author Moyz
     * @date 2021/02/15 15:10
     */
    @ApiOperation("新增或更新验证码表")
    @GetMapping("code")
    public Boolean sentSmsCode(@RequestParam("phone") String phone) {
        /*
         * 0. 先查询有无此手机号，无手机号则进行注册（数据库写入）
         * 1. 去数据库查询是否已存在验证码(若验证码生成小于1分钟则不生成新的)
         * 2. 若存在则返回 false , 若成功则进行下一步
         * 3. 生成验证码并存到数据库，设置生效时间
         * 4. 调用 SendSmsImpl 进行发送
         * */

        if (smsService.isEmptyPhone(phone)) {
            //判断时间小于一分钟就更新
            if (smsService.checkTime(phone)) {
                smsService.updateSms(new Sms(phone, smsService.smsCode()));
            } else {
                //判断时间大于一分钟则更新code
                return false;
            }
        } else {
            // 无手机号则进行注册（数据库写入)并发送code
            smsService.addSms(new Sms(phone, smsService.smsCode()));
        }
        return smsService.sendSmsCode(phone, smsService.getById(phone).getCode());
    }

    /**
     * 校 验 验 证 码
     *
     * @return ErrorCode 101 -> 时间过期 或 未注册，ErrorCode 102 -> 验证码错误
     * @author Moyz
     * @date 2021/02/15 15:10
     */
    @ApiOperation("核对验证码")
    @GetMapping("check")
    public String check(
            @RequestParam("phone") String phone,
            @RequestParam("userCode") String userCode
    ) {
        if (RESULT.equals(smsService.checkCode(phone, userCode))) {
            //设置权限
            return RESULT;
        } else {
            return smsService.checkCode(phone, userCode);
        }
    }
}
