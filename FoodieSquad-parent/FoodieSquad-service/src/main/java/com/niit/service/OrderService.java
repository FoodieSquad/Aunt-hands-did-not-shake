package com.niit.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.OrderMapper;

import com.niit.pojo.Order;


@Service 
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	public int deleteByPrimaryKey(@Param("orderId") Integer orderId, @Param("userId") Integer userId, @Param("cartId") Integer cartId) {
		 
		 return orderMapper.deleteByPrimaryKey(orderId, userId, cartId);
	 }

	 public  int insert(Integer userId,String orderType,Integer deliverId,BigDecimal orderPrice,String orderPayType,String orderAddress ){
		 //具体用法参见测试 自动填充下单时间
	    	Order record=new Order();
	    	int orderId=getOrderLatestIdByUserId(userId);
	    	record.setCartId(userId);
	    	record.setDeliverId(deliverId);
	    	record.setOrderAddress(orderAddress);
			record.setOrderId(orderId);
	        record.setOrderPayType(orderPayType);
	        record.setOrderPrice(orderPrice);
	        record.setOrderStartTimeWithNowTime();
	        record.setOrderType(orderType); 
	        record.setUserId(userId);
	      return orderMapper.insert(record);
	    }

	 public    Order selectByPrimaryKey(@Param("orderId") Integer orderId, @Param("userId") Integer userId, @Param("cartId") Integer cartId){
	    	//cartid=userid
	    	return orderMapper.selectByPrimaryKey(orderId, userId, cartId);
	    }

	 public   List<Order> selectAll(){
	    	return orderMapper.selectAll();
	    }

	 public   List<Order> selectByUserId(@Param("userId") Integer userId){
	    	return orderMapper.selectByUserId(userId);
	    }
	    
	 public   int updateByPrimaryKey(Order record){
		 //用户点击确认收货后更新该订单。
	    	record.setOrderEndTimeWithNowTime();
	    	record.setOrderArriveTimeWithNowTime();
	    	return orderMapper.updateByPrimaryKey(record);
	    }
	 public Order selectLatestOrder(@Param("userId") Integer userId) {
		 List<Order> list=selectByUserId(userId);
		 System.out.println(list.size());
		 Order o=list.get(list.size()-1);
		 return o;
	 }
	
	
	 private Integer getOrderLatestIdByUserId(int userId) {
			List<Order> list=orderMapper.selectByUserId(userId);
             System.out.println(list.size());
		     if(list.size()==0) {
		    	 String num=userId+"00";
		    	 int a=Integer.parseInt(num);
		    	 return a+1;
		     }
		     else {
		    	 Order o=  list.get(list.size()-1);
		    	 return o.getOrderId()+1;
		     }
		    
		     
		

	 }

}
