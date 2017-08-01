package org.wkidt.wkcms.user.controller;
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wkidt.wkcms.common.BaseController;
import org.wkidt.wkcms.common.Result;
import org.wkidt.wkcms.user.form.LoginForm;
import org.wkidt.wkcms.user.form.RegisterForm;
import org.wkidt.wkcms.user.model.User;
import org.wkidt.wkcms.user.service.UserService;
import org.wkidt.wkcms.utils.ChacheUtils;
import org.wkidt.wkcms.utils.RequestUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/21. version 1.0
 */
@Controller
public class UserController extends BaseController<User> {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/login")
    Result login(LoginForm form) {
        try {
            //判断验证码的正确性
//            if (getVerifyCode() == null || !getVerifyCode().equals(form.getVerifyCode())) {
//                //验证码错误
//                view.addObject("info", "验证码错误");
//                return view;
//            }

            //获取用户信息
            User user = userService.login(form.getUserName());
            if (user != null) {
                if (user.getPassword().equals(form.getPassword())) {
                    Subject subject = SecurityUtils.getSubject();
                    //判断客户端
                    if (RequestUtils.isMobileDevice(request)) {
                        //将登录状态保存在redis中
                        logger.info("session ====================== " + subject.getSession());
                        Serializable id = subject.getSession().getId();
                        logger.info("session id ======================= " + id);
                        ChacheUtils.getInstance().put(id, user);
                        Map map = new HashMap();
                        map.put("accentToken", id);
                        return new Result(Result.STATUS_SUCCESS, "登录成功", map);
                    } else {
                        //
                        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
                        subject.login(token);
                    }
                    //登录成功
                    return new Result(Result.STATUS_SUCCESS, "登录成功");
                } else {
                    //密码错误
                    return new Result(Result.STATUS_ERROR, "密码错误");
                }
            } else {
                //用户不存在
                return new Result(Result.STATUS_ERROR, "用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }

    /**
     * 用户注册
     *
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/register")
    Result register(RegisterForm form) {
        try {
            userService.register(form);
            return new Result(Result.STATUS_SUCCESS, "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/user/logout")
    @ResponseBody
    Result logout() {
        removeLoginUser();
        SecurityUtils.getSubject().logout();
        return new Result(Result.STATUS_SUCCESS, "退出成功");
    }


}
