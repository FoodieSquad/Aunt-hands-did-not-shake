package com.niit.mapper;

import com.niit.pojo.Dish;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DishMapper {
    int deleteByPrimaryKey(Integer dishId);

    int insert(Dish record);

    Dish selectByPrimaryKey(Integer dishId);

    List<Dish> selectAll();

    int updateByPrimaryKey(Dish record);
    
    List<Dish> selectByWindowId(Integer windowId);
    
    List<Dish> selectDishesByCartId(@Param("cartId") Integer cartId);
    
    List<Dish>  searchByDishName(@Param("name") String dishName);
    
}