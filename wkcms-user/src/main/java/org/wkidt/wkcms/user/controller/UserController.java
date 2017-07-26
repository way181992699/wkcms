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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.wkidt.wkcms.common.BaseController;
import org.wkidt.wkcms.user.form.LoginForm;
import org.wkidt.wkcms.user.form.RegisterForm;
import org.wkidt.wkcms.user.model.User;
import org.wkidt.wkcms.user.service.UserService;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/21. version 1.0
 */
@Controller
public class UserController extends BaseController<User> {

    @Autowired
    UserService userService;

    @RequestMapping("user/page/login")
    String loginPage() {
        return viewPath("user/login");
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    ModelAndView login(LoginForm form) {
        ModelAndView view = new ModelAndView(viewPath("cms/user/login"));
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
                    //
                    saveLoginUser(user);
                    //登录成功
                    view.setViewName("redirect:/");
                } else {
                    //密码错误
                    view.addObject("info", "密码错误");
                }
            } else {
                //用户不存在
                view.addObject("info", "用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            view.addObject("info", "系统异常，无法登录");
        }
        return view;
    }

    @RequestMapping("/user/page/register")
    String registerPage() {
        return viewPath( "user/register");
    }


    ModelAndView register(RegisterForm form) {
        ModelAndView view = new ModelAndView("");
        try {

        } catch (Exception e) {
            e.printStackTrace();
            view.addObject("info", "系统异常，注册失败");
        }
        return view;
    }


    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/user/logout")
    String logout() {
        removeLoginUser();
        return "/";
    }


}
