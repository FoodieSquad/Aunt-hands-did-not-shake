package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.pojo.HistoryItem;
import com.niit.pojo.User;
import com.niit.service.HistoryService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/test.do")
	public ModelAndView test(HttpSession session) {
		
		User u=(User)session.getAttribute("u");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("homePage");
		
		
		
		return mv;
	}
}
