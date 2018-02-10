package com.zlb.ssm.web.controller;

import com.google.code.kaptcha.Producer;
import com.zlb.entity.captcha.UserCaptcha;
import com.zlb.entity.common.Reply;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by Lubiao Zheng
 * Created time 2018/2/5 14:48
 * Description
 */
@Controller
@RequestMapping("/captcha")
public class RestKaptchaController {

    /*@Resource
    private UserService userService;*/

    @Resource
    private Producer captchaProducer;

    @RequestMapping(value = "/captchaImage")
    @ResponseBody
    public void getKaptchaImage(HttpSession httpSession, HttpServletResponse response) throws Exception {
        String sessionId = httpSession.getId();
        System.out.println("getKaptchaImage-sessionId: " + sessionId);
        String captcha = String.valueOf(httpSession.getAttribute("captcha"));
        System.out.println("getKaptchaImage-captcha: " + captcha);
        //httpSession.setMaxInactiveInterval(30);
        /*Cookie cookie = new Cookie(Constants.KAPTCHA_SESSION_KEY, capText); // 生成cookie
        cookie.setMaxAge(300); // 300秒生存期
        response.addCookie(cookie); // 将cookie加入response*/
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();// 生成验证码字符串
        BufferedImage bi = captchaProducer.createImage(capText);// 生成验证码图片
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        //方案A 保存验证码到redis  redis设置过期时间 过期自动删除
        /*UserCaptcha userCaptcha = new UserCaptcha();
        userCaptcha.setCaptchaId(sessionId);
        userCaptcha.setCaptcha(capText);
        userService.addUserCaptcha(userCaptcha);*/
        //方案B 存放在redis
        httpSession.setAttribute("captcha", capText);
        String captcha2 = String.valueOf(httpSession.getAttribute("captcha"));
        System.out.println("getKaptchaImage-captcha2: " + captcha2);
        return;
    }

    @RequestMapping(value = "/verifyCaptcha")
    @ResponseBody
    public Reply verifyCaptcha(@RequestBody UserCaptcha userCaptcha, HttpSession httpSession) throws Exception {
        Reply reply = new Reply();
        String sessionId = httpSession.getId();
        System.out.println("verifyCaptcha-sessionId: " + sessionId);
        String captcha = (String)httpSession.getAttribute("captcha");
        if (StringUtils.isBlank(captcha)) {
            reply.setRes(1);
            reply.setMsg("验证码失效！");
            System.out.println("验证码失效！");
        }
        if (captcha.equalsIgnoreCase(userCaptcha.getCaptcha())) {
            System.out.println("验证成功！");
        } else {
            reply.setRes(2);
            reply.setMsg("验证码错误！");
            System.out.println("验证码错误！");
        }
        return reply;
    }
}
