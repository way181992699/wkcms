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


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wkidt.wkcms.common.AbstractService;
import org.wkidt.wkcms.common.Page;
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
    
    //分页查询用户信息
	@Override
	public Page<User> pageSelectUser(Page  page) {		
		Page<User> pa = new Page<User>();
		pa.setData(userMapper.pageSelectUser(page.getPageCount(), (page.getCurrentPage()-1)*page.getPageCount()));
		pa.setTota(userMapper.getCount());
		return pa;
	}
	
	//用户新增
	@Override
	public boolean insert(User record) {
		int result = userMapper.insert(record);
		if (result>0) {
			return true;
		}
		return false;
		}
	
	//用户修改
	@Override
	public boolean updateByPrimaryKey(User record) {
		int result = userMapper.updateByPrimaryKey(record);
		if (result>0) {
			return true;
		}
		return false;
		}
	
	//用户删除
	@Override
	public boolean deleteByPrimaryKey(Long userId) {
		int result = userMapper.deleteByPrimaryKey(userId);
		if (result>0) {
			return true;
		}
		return false;
		}
	
	//根据userId 查询用户信息
	@Override
	public User selectByPrimaryKey(Long userId) {
		
		
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int changePassword(User user) {
		// TODO Auto-generated method stub
	
		return userMapper.changePassword(user);
	}



	
	}

