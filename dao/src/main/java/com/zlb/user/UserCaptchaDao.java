package com.zlb.user;

import cn.joinhealth.hug.model.entity.user.UserCaptcha;

/**
 * Created by Lubiao Zheng
 * Created time 2018/2/5 16:48
 * Description
 */
public interface UserCaptchaDao {

    /**
     *
     * @param userCaptcha
     * @return
     */
    void add(UserCaptcha userCaptcha);

    /**
     * 获取验证码
     * @param captchaId
     * @return
     */
    UserCaptcha get(String captchaId);
}
