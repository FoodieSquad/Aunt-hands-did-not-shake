package com.niit.mapper;

import com.niit.pojo.Order;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(@Param("orderId") Integer orderId, @Param("userId") Integer userId, @Param("cartId") Integer cartId);
    
    int deleteByUserId(@Param("userId") Integer userId);

    int insert(Order record);

    Order selectByPrimaryKey(@Param("orderId") Integer orderId, @Param("userId") Integer userId, @Param("cartId") Integer cartId);

    List<Order> selectAll();

    List<Order> selectByUserId(@Param("userId") Integer userId);
    
    int updateByPrimaryKey(Order record);
}