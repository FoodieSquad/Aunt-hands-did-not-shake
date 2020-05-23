package com.niit.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.FavoriteMapper;
import com.niit.pojo.Favorite;
@Service
public class FavoriteService {
	@Autowired
	private FavoriteMapper favoriteMapper;
	public  int deleteByPrimaryKey(@Param("favoriteId") Integer favoriteId, @Param("userId") Integer userId) {
		  return favoriteMapper.deleteByPrimaryKey(favoriteId, userId);
	  }
	public   int insert(@Param("favoriteId") Integer favoriteId, @Param("userId") Integer userId){
		   return favoriteMapper.insert(favoriteId, userId);
	   }
	    // List<Favorite> selectAll();
	public    Favorite selectByUserId(@Param("userId") Integer userId){
	    	 return favoriteMapper.selectByUserId(userId);
	     }//一个用户一个favorite
}
