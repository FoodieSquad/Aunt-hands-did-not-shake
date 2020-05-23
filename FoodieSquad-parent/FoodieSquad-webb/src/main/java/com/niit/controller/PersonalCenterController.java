package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.pojo.User;

@Controller
@RequestMapping("/personalCenter")
public class PersonalCenterController {
	@RequestMapping("/test.do")
	public ModelAndView test(HttpSession session) {
		User u=(User)session.getAttribute("u");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("personalCenterPage");
		mv.addObject("userName", u.getUserName());
		return mv;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("loginPage");
		return mv;
	}
}
