package org.wkidt.wkcms.user.service;
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


import java.util.List;

import org.wkidt.wkcms.common.Page;
import org.wkidt.wkcms.user.model.User;

/**
 * 用户业务接口
 * <p>
 * Created by zcm on 2017/7/20. version 1.0
 */

public interface UserService {

    /**
     * 登录
     *
     * @param userName
     * @return
     */
    User login(String userName);

    /**
     * 注册
     *
     * @param user
     */
    void register(User user);

    /**
     * 
     * 分页查询用户信息
     * 
     * @return
     */
    Page<User> pageSelectUser(Page page);
    
    /**
     * 用户新增
     * 
     * @param record
     * @return int 
     */
    boolean insert(User record);
    
}
