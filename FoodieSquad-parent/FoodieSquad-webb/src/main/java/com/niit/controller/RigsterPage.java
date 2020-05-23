package com.niit.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.pojo.User;
import com.niit.pojo.UserAddress;
import com.niit.pojo.UserTele;
import com.niit.service.UserService;

@Controller
@RequestMapping("/register")
public class RigsterPage {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test.do")
	public ModelAndView test() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("registerPage");
		mv.addObject("userPhone", "18253738936");
		return mv;
	}
	@RequestMapping("/submit.do")
	public ModelAndView submit(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		
		User user=new User();
		user.setUserName(request.getParameter("username"));
		user.setUserPassword(request.getParameter("password"));
		user.setUserStudentNum(request.getParameter("stunum"));
		user.setUserGender(request.getParameter("gender"));
		UserAddress userAddress=new UserAddress();
		userAddress.setUserAddress(request.getParameter("address"));
		UserTele userTele=new UserTele();
		userTele.setUserTele(request.getParameter("tel"));
		List<UserAddress> userAddressList=new ArrayList<UserAddress>();
		List<UserTele> userTeleList=new ArrayList<UserTele>();
		userAddressList.add(userAddress);
		userTeleList.add(userTele);
		user.setUserAddress(userAddressList);
		user.setUserTele(userTeleList);
		user.setUserType(0);
		BigDecimal userBalance=new BigDecimal(100);
		user.setUserBalance(userBalance);
		int status=userService.insert(user);
		if(status==0) {
			System.out.println("手机号已经被注册或注册成功啦！");
			mv.setViewName("alreadyhavephone");
			return mv;
		}else {
			mv.setViewName("loginPage");
			return mv;
		}
		
	}
}
