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

import java.util.HashMap;

/**
 * Description
 * <p>
 * Created by zcm on 2017/8/1. version 1.0
 */

public final class ChacheUtils {

    private static ChacheUtils instance;
    private HashMap<Object, Object> map = new HashMap<>();

    private ChacheUtils() {
    }

    public static ChacheUtils getInstance() {
        synchronized (ChacheUtils.class) {
            if (instance == null)
                instance = new ChacheUtils();
        }
        return instance;
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }

    public Object get(Object key) {
        return map.get(key);
    }

    public HashMap<Object, Object> getMap() {
        return map;
    }
}
