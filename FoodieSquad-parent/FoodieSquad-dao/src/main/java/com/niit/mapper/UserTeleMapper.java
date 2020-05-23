package com.niit.mapper;


import com.niit.pojo.UserTele;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTeleMapper {
    int deleteByPrimaryKey(@Param("userTeleId") Integer userTeleId, @Param("userId") Integer userId);
    
    int deleteByUserId( @Param("userId") Integer userId);
    
    int insert(UserTele record);

    UserTele selectByPrimaryKey(@Param("userTeleId") Integer userTeleId, @Param("userId") Integer userId);

    List<UserTele> selectAll();
    
    List<UserTele> selectByUserId(@Param("userId") Integer userId);


    int updateByPrimaryKey(UserTele record);
   
    UserTele selectUserIdByUserTele(String userTele);
}