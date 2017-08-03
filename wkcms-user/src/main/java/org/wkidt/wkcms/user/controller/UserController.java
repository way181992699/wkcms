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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wkidt.wkcms.common.BaseController;
import org.wkidt.wkcms.common.Page;
import org.wkidt.wkcms.common.PageResult;
import org.wkidt.wkcms.common.Result;
import org.wkidt.wkcms.user.form.LoginForm;
import org.wkidt.wkcms.user.form.RegisterForm;
import org.wkidt.wkcms.user.model.User;
import org.wkidt.wkcms.user.service.UserService;
import org.wkidt.wkcms.utils.ChacheUtils;
import org.wkidt.wkcms.utils.RequestUtils;

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
	@RequestMapping(value = "/user/login",method=RequestMethod.POST)
	Result login(LoginForm form) {
		try {
			// 判断验证码的正确性
			// if (getVerifyCode() == null ||
			// !getVerifyCode().equals(form.getVerifyCode())) {
			// //验证码错误
			// view.addObject("info", "验证码错误");
			// return view;
			// }

			// 获取用户信息
			User user = userService.login(form.getUserName());
			if (user!= null) {
				if (user.getPassword().equals(form.getPassword())) {
					Subject subject = SecurityUtils.getSubject();
					// 判断客户端
					if (RequestUtils.isMobileDevice(request)) {
						// 将登录状态保存在redis中
						Serializable id = subject.getSession().getId();
						ChacheUtils.getInstance().put(id, user);
						Map map = new HashMap();
						map.put("accentToken", id);
						return new Result(Result.STATUS_SUCCESS, "登录成功", map);
					} else {
						//
						UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
						subject.login(token);
					}
					// 登录成功
					return new Result(Result.STATUS_SUCCESS, "登录成功");
				} else {
					// 密码错误
					return new Result(Result.STATUS_ERROR, "密码错误");
				}
			} else {
				// 用户不存在
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
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
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
		SecurityUtils.getSubject().logout();
		return new Result(Result.STATUS_SUCCESS, "退出成功");
	}
	  /**
     * 
     * 分页查询用户
     * @author wkx 
     * @param page
     * @return
     */
    @RequestMapping(value="/user/pagedQuery",method=RequestMethod.GET)
    @ResponseBody 
    PageResult<User> pageSelectUser(Page  page){
    	try {
    	Page<User> p =userService.pageSelectUser(page);
    	
    	return new PageResult<User>(Result.STATUS_SUCCESS, "查询成功", p);
    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    
    	return new PageResult<User>(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    	
    }
    
    /**
     * 新增用户
     * @author wkx 
     * @param record
     * @return
     */
    @RequestMapping("/user/insert")
    @ResponseBody
    Result<User> insert(User record){
    	try {
    		boolean result = userService.insert(record);
    		if (result==true) {
				return new Result<User>(Result.STATUS_SUCCESS, Result.MESSAGE_SUCCESS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return new Result<User>(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }
    
    /**
     * 根据userId 查询出用户信息
     * @author wkx 
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/findUserByUserId")
    Result<User> selectByPrimaryKey(Long userId){
    	try {
			
    		User user = userService.selectByPrimaryKey(userId);
    		if (user!=null) {
				return new Result<User>(Result.STATUS_SUCCESS,Result.MESSAGE_SUCCESS,user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return new Result<User>(Result.STATUS_UNKNOW,Result.MESSAGE_UNKNOW);
    }
    
    
    /**
     * 修改用户
     * @author wkx 
     * @param record
     * @return
     */
    @RequestMapping(value="/user/update",method=RequestMethod.POST)
    @ResponseBody
    Result<User> updateByPrimaryKey(User record){
    	try {
    		boolean result = userService.updateByPrimaryKey(record);
    		if (result==true) {
				return new Result<User>(Result.STATUS_SUCCESS, Result.MESSAGE_SUCCESS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return new Result<User>(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }
    
    
    /**
     * 删除用户
     * @author wkx 
     * @param record
     * @return
     */
    @RequestMapping("/user/delete")
    @ResponseBody
    Result<User> deleteByPrimaryKey(Long userId){
    	try {
    		boolean result = userService.deleteByPrimaryKey(userId);
    		if (result==true) {
				return new Result<User>(Result.STATUS_SUCCESS, Result.MESSAGE_SUCCESS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return new Result<User>(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
    }
    
   /**
    * 修改用户密码(用户名和旧密码同时成立才能修改)
    * @author wkx
    * @param userName
    * @param oldPwd
    * @param newPwd
    * @return
    */
   @RequestMapping(value="/user/changePwd",method=RequestMethod.POST)
   @ResponseBody
   Result changePassword(String userName,String oldPwd,String newPwd){
	   try {
		   int result = userService.changePassword(userName,oldPwd,newPwd);
		   if (result>0) {
			return new Result(Result.STATUS_SUCCESS, "修改成功");
		
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	   return new Result(Result.STATUS_UNKNOW, Result.MESSAGE_UNKNOW);
   }
   

}