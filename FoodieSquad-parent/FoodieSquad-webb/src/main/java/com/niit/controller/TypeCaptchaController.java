package com.niit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zhenzi.sms.ZhenziSmsClient;

@Controller
@RequestMapping("/typeCaptcha")
public class TypeCaptchaController {
	
	public Cookie savephonenum(String cellnum,HttpServletResponse response) {
		System.out.println("Cookie cookie = new Cookie(\"oldcellnum\",cellnum);"+cellnum);
		 Cookie cookie = new Cookie("oldcellnum",cellnum);
	   cookie.setMaxAge(60*2);
	   response.addCookie(cookie);
	   return cookie;
	}
	
	public Cookie getCookie(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null)
		{
			for (Cookie cookie : cookies)
			{

				if (!cookie.getName().equals("oldcellnum"))
					continue;
				else {System.out.println("find cookie");}
				return cookie;
			}

		}
		return null;
		
	}

	@RequestMapping("/test.do")
	public ModelAndView test(@Param("cellnum") String cellnum,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("typeCaptchaPage");
		System.out.println("String oldcellnum=(String)session.getAttribute(cellnum);");
		Cookie c=getCookie(request);
		if(c!=null){
        	String oldnum=c.getValue();
        	System.out.println("String oldnum=c.getValue();"+oldnum);
        	System.out.println("String cellnum"+cellnum);
        	if(oldnum.equals(cellnum)) {
        		System.out.println("检测到相同电话号码，五分钟之内不再发送！");
        		try {
        			request.getRequestDispatcher("../login/verifyuser.do?userphone="+cellnum).forward(request,response);
        		} catch (ServletException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		return null;
        	}}
		
	     //如果请求的是同一个电话号码；不发送短信；
	     String verifyCode = String.valueOf(new Random().nextInt(8999) + 1000);
        //发送短信
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","103913", "0c1baf57-3fb6-4ec0-97a3-9bcb9d4a9988");
        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "您的验证码为:" + verifyCode + "，该码有效期为5分钟，该码只能使用一次！");
        params.put("number", cellnum);
        try {
			String result = client.send(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        mv.addObject("verifyCode", verifyCode);
		
      
        mv.addObject("cellnum", cellnum);
        System.out.println(" savephonenum(cellnum);");
        savephonenum(cellnum,response);
       
      
		return mv;
	}
}
