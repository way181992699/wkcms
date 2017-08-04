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


import org.wkidt.wkcms.common.form.PageForm;
import org.wkidt.wkcms.common.model.Page;
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
     * @author wkx
     * @return
     */
    Page<User> pageSelectUser(PageForm pageForm);
    
    /**
     * 用户新增
     * @author wkx
     * @param record
     * @return boolean
     */
    boolean insert(User record);
    
    /**
     * 用户修改
     * @author wkx
     * @param record
     * @return boolean 
     */
    boolean updateByPrimaryKey(User record);
    
    /**
     * 用户删除
     * @author wkx
     * @param record
     * @return boolean 
     */
    boolean deleteByPrimaryKey(Long userId);
    
    /**
     * 
     * 根据userId 查询用户信息
     * @author wkx
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Long userId);
    
  
    /**
     * 
     * 修改用户密码(用户名和旧密码同时成立才能修改)
     * @author wkx
     * @param userName
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int changePassword(String userName,String oldPwd,String newPwd);
}
