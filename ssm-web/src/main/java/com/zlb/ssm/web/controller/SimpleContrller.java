package com.zlb.ssm.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/11.
 */
@Controller
public class SimpleContrller {

    private static final Logger logger = Logger.getLogger(SimpleContrller.class);

    /*@Resource
    private DockingService dockingService;

    @Resource
    private ImgDataHandleService imgDataHandleService;

    @Resource
    private HomePageService homePageService;

    @Resource
    private UserService userService;


    @RequestMapping("/")
    public ModelAndView simpleMethed(HttpServletRequest request) {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/manage")
    public ModelAndView queryDictHospDetail(User user) {
        return new ModelAndView("data");
    }

    @RequestMapping(value = "/listDteHosp")
    public ModelAndView listDteHosp() {
        ModelAndView mav = new ModelAndView("listDteHosp");
        List hosps = dockingService.listHosp();
        mav.addObject("hosps", hosps);
        return mav;
    }
    @RequestMapping(value = "/upload")
    public ModelAndView upload(User user) {
        return new ModelAndView("upload");
    }

    *//**
     * 数据处理 (只处理一次)get 请求
     * @return
     *//*
    @RequestMapping(value = "/testImgData")
    public Reply testImgData() throws HugException{
        Reply reply = new Reply();
//        imgDataHandleService.insertImageTable();
//        imgDataHandleService.updateTables();
        reply.setData("ok ---");
        return reply;
    }

    *//**
     * 获取年报数据
     * @param annualReportReq
     * @return
     *//*
    @RequestMapping(value = "/annual")
    @ResponseBody
    public Reply getAnnual(@RequestBody AnnualReportReq annualReportReq, HttpSession httpSession) {
        Reply reply = new Reply();
        //校验图片验证码
        if (StringUtils.isNotBlank(annualReportReq.getCaptcha())) {
            logger.info("captcha: " + httpSession.getAttribute("captcha"));
            String captcha = String.valueOf(httpSession.getAttribute("captcha"));
            if (StringUtils.isBlank(captcha)) {
                reply.setRes(ErrorConstant.USER_10031);
                reply.setMsg(ErrorConstant.USER_MSG_10031);
                return reply;
            }
            if (!annualReportReq.getCaptcha().equalsIgnoreCase(captcha)) {
                reply.setRes(ErrorConstant.USER_10032);
                reply.setMsg(ErrorConstant.USER_MSG_10032);
                return reply;
            }
        }
        if (StringUtils.isNotBlank(annualReportReq.getId())) {
            String s = AESUtils.AESDncode(CommonConstant.DEFAULT_PASSWORD, annualReportReq.getId());
            String[] strings =  s.split(":");
            annualReportReq.setPatName(strings[0]);
            annualReportReq.setVisitCardNo(strings[1]);
            annualReportReq.setHospCode(strings[2]);
        }
        List<AnnualReport> annualReports = homePageService.getAnnual(annualReportReq);
        Map returnMap = new HashMap<>();
        returnMap.put("id", AESUtils.AESEncode(CommonConstant.DEFAULT_PASSWORD,annualReportReq.getPatName() + ":" + annualReportReq.getVisitCardNo() + ":" + annualReportReq.getHospCode()));
        returnMap.put("reports", annualReports);
        reply.setData(returnMap);
        return reply;
    }

    public static void main(String[] args) {
        String a = AESUtils.AESEncode(CommonConstant.DEFAULT_PASSWORD,"朱爱香"+":" + "A11443272" + ":470180835");
        String s = AESUtils.AESDncode(CommonConstant.DEFAULT_PASSWORD, a);
        System.out.println(s);
    }

    *//**
     * 页面跳转
     * @param module
     * @param page
     * @return
     *//*
    @RequestMapping(value = "/v2/{module}/{page}", method = RequestMethod.GET)
    public String jump(@PathVariable("module") String module,
                       @PathVariable("page") String page, @RequestParam Map map, Model model) {
        if (map != null) {
            model.addAllAttributes(map);
        }
        return module + "/" + page;
    }*/
}
