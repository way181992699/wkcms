package org.wkidt.wkcms.common;//
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

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.wkidt.wkcms.conf.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 基类控制器
 * <p>
 * Created by zcm on 2017/7/15. version 1.0
 *
 * @param <E>
 */

public abstract class BaseController<E> {
    protected Logger logger = Logger.getLogger(this.getClass());

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void initRequest(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(true);
    }

    /**
     * 保存登录用户到session
     *
     * @param user
     */
    protected void saveLoginUser(E user) {
        if (session == null)
            throw new NullPointerException("Session is null ");
        session.setAttribute(Config.USER_KEY, user);
    }

    /**
     * 获取登录用户
     *
     * @return
     */
    protected E getLoginUser() throws IllegalAccessException, InstantiationException {
        if (session == null)
            throw new NullPointerException("Session is null");
        Object loginUser = session.getAttribute(Config.USER_KEY);
        if (loginUser != null) {
            return (E) loginUser;
        }
        return null;
    }

    /**
     * 删除登录用户
     */
    protected void removeLoginUser() {
        if (session == null)
            throw new NullPointerException("Session is null");
        session.removeAttribute(Config.USER_KEY);
    }

    /**
     * 图片验证码
     *
     * @return
     */
    protected String getVerifyCode() {
        return (String) session.getAttribute(Config.CODE_VERIFY);
    }



}
