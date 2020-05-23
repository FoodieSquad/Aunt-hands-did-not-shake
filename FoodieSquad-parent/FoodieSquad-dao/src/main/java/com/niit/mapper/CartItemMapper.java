package com.niit.mapper;

import com.niit.pojo.CartItem;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CartItemMapper {
    int deleteByPrimaryKey(Integer cartItemId);

    int insert2(@Param("cartId") Integer cartId,@Param("dishId") Integer dishId,@Param("dishCount") Integer dishCount);
    
    int insert(CartItem record);


    CartItem selectByPrimaryKey(Integer cartItemId);

    List<CartItem> selectAll();

    int updateByPrimaryKey(CartItem record);
    
    CartItem TestIfHasIt(Integer cartItemId);
    
    int deleteBycartId(Integer cartId);
    
    
}