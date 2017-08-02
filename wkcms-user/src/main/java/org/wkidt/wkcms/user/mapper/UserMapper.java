
package org.wkidt.wkcms.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.wkidt.wkcms.user.model.User;

import java.util.List;

public interface UserMapper {
	
	/**
	 * 删除用户信息
	 * @author wkx
	 * @param userId
	 * @return
	 */
    int deleteByPrimaryKey(Long userId);
    
    /**
     * 添加用户
     * @author wkx
     * @param record
     * @return
     */
    int insert(User record);

    int insertSelective(User record);
    
    /**
     * 
     * 根据userId 查询用户信息
     * @author wkx
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Long userId);
    
    int updateByPrimaryKeySelective(User record);

    
    /**
     * 根据主键ID 修改用户信息
     * @author wkx
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();
    
    /**
     * 
     * 分页查询用户信息
     * @author wkx
     * @return
     */
    List<User> pageSelectUser(@Param("pageCount") int pageCount,@Param("offset") int offset);

    /**
     * 用户名查找
     * @author wkx
     * @param userName
     * @return
     */
    User selectByUserName(@Param("userName") String userName);
    
    /**
     * 
     * 查询用户的总数
     * @author wkx
     * @return
     */
    long getCount();
    
    /**
     * 
     * 修改用户密码
     * 
     * @return int
     */
     int changePassword(User user);


}
