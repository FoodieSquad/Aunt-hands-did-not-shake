package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.CartItemMapper;
import com.niit.mapper.CartMapper;
import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
@Service
public class CartService {
	@Autowired
	CartMapper cartMapper;
	@Autowired
	CartItemMapper cartItemMapper;
	
	
public	 int deleteByPrimaryKey(Integer cartId) {
		 return cartMapper.deleteByPrimaryKey(cartId);
	 }
public	 int cleanByPrimaryKey(Integer cartId) {
	cartItemMapper.deleteBycartId(cartId);
    return 1;
}

public int insert(Integer cartId) {
	return cartMapper.insert(cartId);
	
}
public int insertOneItem(Integer cartId,Integer dishId,Integer dishCount) {
	cartItemMapper.insert2(cartId, dishId, dishCount);
	return 1;
	
	    }


public	Cart selectByPrimaryKey(Integer cartId) {
	    	return cartMapper.selectByPrimaryKey(cartId);
	    }



public  List<Cart> selectAll(){
	    	return cartMapper.selectAll();
	    }



//public int update(Cart record) {
////	List<CartItem> cartItemlist=record.getCartItemId();
////	 for(CartItem c:cartItemlist) 
////	    	c.setCartId(record.getCartId());
////	if(cartItemlist!=null) 
////	    for(CartItem c:cartItemlist) {
////	    	if(c.getCartItemId()==null) {
////	    		cartItemMapper.insert(c.getCartId(), c.getDishId(), c.getDishCount());
////	    		continue;
////	    	}
////	    	CartItem c1=cartItemMapper.TestIfHasIt(c.getCartItemId()); 
////	    	if(c1!=null)
////	    	cartItemMapper.updateByPrimaryKey(c);
////	    	else
////	    	cartItemMapper.insert(c);}
//  return 1;
//	
//	
//	//表示无更新；
//}


	
	

	    
	    
	    
}
