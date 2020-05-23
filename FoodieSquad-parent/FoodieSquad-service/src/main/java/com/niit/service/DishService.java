package com.niit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.DishMapper;
import com.niit.pojo.Dish;
@Service
public class DishService {
	@Autowired
	private DishMapper dishMapper;
	public int deleteByPrimaryKey(Integer dishId) {
		 return dishMapper.deleteByPrimaryKey(dishId);
	 }

	public    int insert(Dish record){
	    	
	   return dishMapper.insert(record);
	    }

	public    Dish selectByPrimaryKey(Integer dishId){
	    	return dishMapper.selectByPrimaryKey(dishId);
	    }

	public    List<Dish> selectAll(){
	    	return dishMapper.selectAll();
	    }

	public    int updateByPrimaryKey(Dish record){
	    	return dishMapper.updateByPrimaryKey(record);
	    }
	    
	public   List<Dish> selectByWindowId(Integer windowId){
	    	return dishMapper.selectByWindowId(windowId);
	    }
	    
	public    List<Dish> selectDishesByCartId(@Param("cartId") Integer cartId){
	    	
	    	return dishMapper.selectDishesByCartId(cartId);
	    }
	
	public	List<Dish>  searchByDishName(String dishName){
		if(dishName==null || dishName=="")
			return null;
		return dishMapper.searchByDishName(dishName);
	}
	    
}
