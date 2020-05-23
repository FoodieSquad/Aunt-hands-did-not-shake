package com.niit.mapper;

import com.niit.pojo.Cart;
import com.niit.pojo.User;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
int deleteByPrimaryKey(Integer userId);

int insert(User record);

User selectByPrimaryKey(Integer userId);

List<User> selectAll();

int updateByPrimaryKey(User record);

int updateCartId(Integer userId);
    
 
}