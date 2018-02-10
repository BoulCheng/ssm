package com.zlb.entity.captcha;

import java.io.Serializable;

/**
 * Created by Lubiao Zheng
 * Created time 2018/2/5 16:50
 * Description 用户验证码
 */
public class UserCaptcha implements Serializable {
    private static final long serialVersionUID = -5761880957027097955L;

    private String captchaId;

    private String captcha;

    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
