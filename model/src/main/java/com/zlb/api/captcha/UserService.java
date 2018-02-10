package com.zlb.api.captcha;

import com.zlb.entity.captcha.UserCaptcha;

public interface UserService {

    /**
     * 添加用户图片验证码到redis
     * @param userCaptcha
     */
    void addUserCaptcha(UserCaptcha userCaptcha);

    /**
     * 校验用户图片验证码
     * @param captchaId
     */
    String getUserCaptcha(String captchaId);
}
