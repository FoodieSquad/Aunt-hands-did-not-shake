package com.niit.mapper;

import com.niit.pojo.Favorite;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoriteMapper {
     int deleteByPrimaryKey(@Param("favoriteId") Integer favoriteId, @Param("userId") Integer userId);
     int deleteByUserId( @Param("userId") Integer userId);
   int insert(@Param("favoriteId") Integer favoriteId, @Param("userId") Integer userId);
    // List<Favorite> selectAll();
     Favorite selectByUserId(@Param("userId") Integer userId);//一个用户一个favorite
}