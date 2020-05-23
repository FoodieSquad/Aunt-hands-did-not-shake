package com.niit.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.pojo.Canteen;
import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.Dish;
import com.niit.pojo.User;
import com.niit.pojo.UserAddress;
import com.niit.pojo.UserTele;
import com.niit.service.CanteenService;
import com.niit.service.CartService;
import com.niit.service.DeliverService;
import com.niit.service.OrderService;
import com.niit.service.UserService;

@Controller
@RequestMapping("/submitOrder")
public class SubmitOrderController {
	@Autowired
	private CartService cartService;
	@Autowired 
	private CanteenService canteenService;	
	@Autowired
	private OrderService orderService;
	@Autowired
	private DeliverService deliverService;
	@Autowired
	private UserService userService;
	
	//submitOrder/test.do
	@RequestMapping("/test.do")
	public ModelAndView test(HttpSession session) {
		Integer  userId=(Integer)session.getAttribute("userId");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("submitOrderPage");
		
		System.out.println("userId:"+userId);
		
		//计算订单总价
		Cart cart=cartService.selectByPrimaryKey(userId);
		BigDecimal orderPrice = new BigDecimal("0"); 
		BigDecimal singlePrice=new BigDecimal("0");
		System.out.println("List<CartItem> CartItemlist=cart.getCartItemId();");
		List<CartItem> CartItemlist=cart.getCartItemId();
		System.out.println("CartItemlist.size()"+CartItemlist.size());
		List<Dish> dishList=new ArrayList<Dish>();
		for(CartItem ci:CartItemlist) {
			System.out.println("dishList.add(ci.getDishId());");
			dishList.add(ci.getDishId());
			System.out.println(ci.getDishId().getDishId()+" "+ci.getDishId().getDishName()+" "+ci.getDishId().getDishPrice()+" "+ci.getDishCount());
			singlePrice=ci.getDishId().getDishPrice().multiply(new BigDecimal(ci.getDishCount()));
			orderPrice=	orderPrice.add(singlePrice);
			
		}
		String test = dishList.get(0).getDishId()+"";
		int first = Integer.parseInt(test.substring(0,1));
		Canteen canteen=canteenService.selectByPrimaryKey(first);
		mv.addObject("canteenName", canteen.getCanteenName());
		mv.addObject("cartItemList", CartItemlist);
		mv.addObject("dishList",dishList);
		mv.addObject("totalPrice",orderPrice);
		System.out.println("totalPrice "+orderPrice);
		
		//随机分配快递员
		Integer max=deliverService.selectAll().size();//获取快递员的数量max
		java.util.Random random=new java.util.Random();// 定义随机类
		int deliverId=random.nextInt(max)+1;// 返回[0,max)集合中的整数，注意不包括10  
		deliverService.selectByPrimaryKey(deliverId);//// +1后，[0,10)集合变为[1,11)集合，满足要求
		
		//生成订单地址
		List<UserAddress> ua=userService.selectuserAddressByUserId(userId);
		String orderAddress=ua.get(0).getUserAddress();//默认不选情况下为0；
		
		//生成用户电话号码
		List<UserTele> ut=userService.selectuserTeleByUserId(userId);
		String userTele=ut.get(0).getUserTele();
		mv.addObject("userTele",userTele);
		
		System.out.println("orderPrice:"+orderPrice);
		
		String orderType=(String)session.getAttribute("orderType");
		System.out.println("orderType"+orderType);
		
		orderService.insert(userId, orderType, deliverId, orderPrice, null, orderAddress);
	    return mv;
	}
}
