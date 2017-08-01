package org.wkidt.wkcms.utils;
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

import org.wkidt.wkcms.conf.Config;

import javax.servlet.http.HttpServletRequest;

import static org.wkidt.wkcms.conf.Config.USER_AGENT_ANDROID;
import static org.wkidt.wkcms.conf.Config.USER_AGENT_IOS;

/**
 * Description
 * <p>
 * Created by zcm on 2017/8/1. version 1.0
 */

public final class RequestUtils {

    private RequestUtils() {

    }

    /**
     * 客户端识别，优先从参数userAgent中获取客户端标识，若参数中拿不到再从请求头User-Agent中获取
     *
     * @param request
     * @return
     */
    public static boolean isMobileDevice(HttpServletRequest request) {
        return getUserAgent(request).toLowerCase().contains(USER_AGENT_ANDROID)
                || getUserAgent(request).toLowerCase().contains(USER_AGENT_IOS);
    }

    /**
     * @param request
     * @return
     */
    public static String getUserAgent(HttpServletRequest request) {
        String userAgent = request.getParameter(Config.PARAM_USER_AGENT);
        if (userAgent == null) {
            userAgent = request.getHeader(Config.HEAD_USER_AGENT);
        }
        return userAgent;
    }

    /**
     * @param request
     * @return
     */
    public static String getAccentToken(HttpServletRequest request) {
        String accentToken = request.getParameter(Config.PARAM_ACCENT_TOKEN);
        if (accentToken == null) {
            accentToken = request.getHeader(Config.HEAD_ACCENT_TOKEN);
        }
        return accentToken;
    }


}
