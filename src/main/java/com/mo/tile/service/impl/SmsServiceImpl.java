package com.mo.tile.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Sms;
import com.mo.tile.mapper.SmsMapper;
import com.mo.tile.service.SmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * (Sms)表服务实现类
 *
 * @author MoYz
 * @since 2021-02-15 13:43:55
 */
@Service("smsService")
public class SmsServiceImpl extends ServiceImpl<SmsMapper, Sms> implements SmsService {

    Map<String, String> result = new HashMap<>();
    @Resource
    private SmsMapper smsMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean addSms(Sms sms) {
        Date time = new Date();
        sms.setDeadline(new Date(time.getTime() + 5 * 60 * 1000));
        return smsMapper.insert(sms) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean updateSms(Sms sms) {
        Date time = new Date();
        sms.setDeadline(new Date(time.getTime() + 5 * 60 * 1000));
        return smsMapper.updateById(sms) == 1;
    }

    /**
     * 查 询 有 无 此 手 机 号
     */
    @Override
    public Boolean isEmptyPhone(String phoneNum) {
        return smsMapper.selectById(phoneNum) != null;
    }

    /**
     * 检查时间是否小于一分钟
     * 小于一分钟 返回 true
     */
    @Override
    public Boolean checkTime(String phoneNum) {
        Date time = new Date();
        //截至时间 <= 现在时间 + 60
        Sms sms = smsMapper.selectById(phoneNum);
        return sms.getDeadline().getTime() <= new Date(time.getTime() + 60 * 1000).getTime();
    }

    /**
     * 生 成 新 code
     */
    @Override
    public String smsCode() {
        return UUID.randomUUID().toString().substring(0, 4);
    }

    /**
     * 发 送 code
     */
    @Override
    public Boolean sendSmsCode(String phoneNum, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "888", "777");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");

        /**
         * 自 定 义 参 数
         */
        request.putQueryParameter("PhoneNumbers", phoneNum);
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
     * 校 验 验 证 码
     * <p>
     * 1. 先去数据库查询是否已存在验证码
     * 2. 若不存在则返回 false , 若成功则进行下一步
     * 3. 匹配验证码
     * 4. 成功则返回 true，失败返回 false
     */
    @Override
    public Map<String, String> checkCode(String phoneNum, String userCode) {
        Sms sms = smsMapper.selectById(phoneNum);
        if (sms.getDeadline().getTime() <= System.currentTimeMillis() || sms.getCode() == null) {
            //时间过期 或 未注册
            result.put("status", "Error");
            result.put("reason", "Time expired or not registered.[Please Reacquire Verification code]");
            return result;
        } else {
            if (sms.getCode().equals(userCode)) {
                result.put("status", "Success");
            } else {
                //验证码错误
                result.put("status", "Error");
                result.put("reason", "Verification code Error");
            }
            return result;
        }
    }
}