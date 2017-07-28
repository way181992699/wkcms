package org.wkidt.wkcms.user.service.impl;
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


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wkidt.wkcms.common.AbstractService;
import org.wkidt.wkcms.user.mapper.UserMapper;
import org.wkidt.wkcms.user.model.User;
import org.wkidt.wkcms.user.service.UserService;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/20. version 1.0
 */

@Transactional
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }
}
