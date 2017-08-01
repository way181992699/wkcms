package org.wkidt.wkcms.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.wkidt.wkcms.user.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 
     * 分页查询用户信息
     * 
     * @return
     */
    List<User> pageSelectUser(@Param("pageCount") int pageCount,@Param("offset") int offset);

    /**
     * 用户名查找
     *
     * @param userName
     * @return
     */
    User selectByUserName(@Param("userName") String userName);
    
    /**
     * 
     * 查询用户的总数
     * @return
     */
    long getCount();

}