package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.niit.service.AdminService;

@Controller
public class AdminController {
@Autowired
private AdminService adminService;
@RequestMapping("/selectadmin.do")
public String selectadmin() {
	adminService.selectByPrimaryKey(1);
	return "hello";
}

@RequestMapping("/test.do")
public String test() {

	return "chooseCanteenPage";
}


}
