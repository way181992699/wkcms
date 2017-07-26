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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zcm on 2017/7/22. version 1.0
 */
public final class DateFormatUtils {
    private static final String PATTERN_DEAULT = "yyyy-MM-dd";

    private DateFormatUtils() {
    }

    /**
     * 格式化日期
     *
     * @param pattern
     * @param date
     * @return
     */
    public static String format(String pattern, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(PATTERN_DEAULT, date);
    }


}
