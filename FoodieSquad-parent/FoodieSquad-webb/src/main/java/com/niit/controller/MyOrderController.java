package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.pojo.HistoryItem;
import com.niit.pojo.Order;
import com.niit.pojo.User;
import com.niit.service.HistoryService;
import com.niit.service.OrderService;

@Controller
@RequestMapping("/myOrder")

public class MyOrderController {
	

@Autowired
OrderService orderService;
	
@Autowired
private HistoryService historyService;
	
	@RequestMapping("/test.do")
	//  myOrder/test.do
	public ModelAndView test(HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("myOrderPage");
		
		User u=(User)session.getAttribute("u");
		System.out.println("user:id:"+u.getUserId());
		
		List<Order> orderlist=orderService.selectByUserId(u.getUserId());
		
		List<HistoryItem> historyItemlist=historyService.selectByUserId(u.getUserId());

		
		if(historyItemlist.size()==0) {
			mv.addObject("historyItemlist",null);
		}
		else {
			mv.addObject("historyItemlist",historyItemlist);
		}
		
	  if(orderlist.size()==0) {
			
		
			mv.addObject("orderlist",null);
		}
		else {
			
			mv.addObject("orderlist",orderlist);
		}
		
	
		
		return mv;
	}
}
