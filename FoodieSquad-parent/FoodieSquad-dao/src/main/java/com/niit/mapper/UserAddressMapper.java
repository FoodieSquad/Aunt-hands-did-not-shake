package com.niit.mapper;

import com.niit.pojo.UserAddress;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressMapper {
    int deleteByPrimaryKey(@Param("userAddressId") Integer userAddressId, @Param("userId") Integer userId);

    int deleteByUserId( @Param("userId") Integer userId);

    int insert(UserAddress record);

    UserAddress selectByPrimaryKey(@Param("userAddressId") Integer userAddressId, @Param("userId") Integer userId);

    List<UserAddress> selectAll();
    
    List<UserAddress> selectByUserId(@Param("userId") Integer userId);

    int updateByPrimaryKey(UserAddress record);
    
    
    
}