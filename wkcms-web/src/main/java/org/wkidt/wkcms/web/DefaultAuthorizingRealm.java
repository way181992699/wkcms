package org.wkidt.wkcms.web;
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
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wkidt.wkcms.user.model.Permission;
import org.wkidt.wkcms.user.model.Role;
import org.wkidt.wkcms.user.model.User;
import org.wkidt.wkcms.user.service.UserService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/25. version 1.0
 */
public class DefaultAuthorizingRealm extends AuthorizingRealm {
    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("============================= doGetAuthorizationInfo =================================");
        String username = (String) principals.getPrimaryPrincipal(); //获取用户名
        User user = userService.login(username);
        if (user == null)
            return null;

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //配置角色
        Set<String> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            roles.add(role.getRoleName());
        }
        authorizationInfo.setRoles(roles);
        //配置权限
        Set<String> permissions = new HashSet<>();
        for (Role role : user.getRoles()) {
            for (Permission permission : role.getPermissions()) {
                permissions.add(permission.getPermissionName());
            }
        }
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    // 验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        logger.info("============================= doGetAuthenticationInfo =================================");
        String username = (String) token.getPrincipal(); // 获取用户名
        User user = userService.login(username);
        if (user != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}

