package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.exception.RecordNotFoundException;
import com.niit.pojo.Dish;
import com.niit.pojo.Favorite;
import com.niit.pojo.HistoryItem;
import com.niit.pojo.Order;
import com.niit.pojo.User;
import com.niit.pojo.UserTele;
import com.niit.service.FavoriteService;
import com.niit.service.HistoryService;
import com.niit.service.OrderService;
import com.niit.service.UserService;
import com.niit.util.ProcessTime;

@SessionAttributes(value="{u}",types= {User.class})
@Controller
@RequestMapping("/login")
public class LoginController {
	
@Autowired
UserService userService;
@Autowired
OrderService orderService;
@Autowired
private FavoriteService favoriteService;

@Autowired
private HistoryService historyService;
private ProcessTime processTime=new ProcessTime();

	//  login/test.do
	@RequestMapping("/test.do")
	public String test(HttpSession session,Model m) {
	 session.setMaxInactiveInterval(10*24*60*60);
	 String userphone=(String)session.getAttribute("userphone");
	 if(userphone!=null) {
		String date=processTime.getStringNowTimeWithDate();
		m.addAttribute("date", date);
		return "homePage";
			}
		 
	   return "loginPage";
	}
	
	@RequestMapping("/testException.do")
	public void testException() {
		 throw new RecordNotFoundException("test");
		
	}
	
	//login/verifyuser.do?userphone=12 可进行断点测试
	@RequestMapping("/verifyuser.do")
	public String verify(@RequestParam("userphone") String userphone,Model m,HttpSession session) {
	
		 String olduserphone=(String)session.getAttribute("userphone");
		 if(olduserphone!=null&&!olduserphone.equals(userphone)) {
			 session.invalidate();
			 return "relogin";
		 }
		UserTele ut=userService.selectUserIdByUserTele(userphone);
		if(ut==null)
		{
			m.addAttribute("userPhone", userphone);
			return "registerPage";
		}
		else {
			int userId=ut.getUserId();
		
			User u=userService.selectByPrimaryKey(userId);
			System.out.println("u:"+u.getUserName());
			System.out.println("u:"+u.getUserId());
			Favorite f=favoriteService.selectByUserId(userId);
			if(f==null) {
				m.addAttribute("fdishlist",null);
				session.setAttribute("fdishlist",null);
				 
				 
				
			}
			else {
				List<Dish> dishlist=f.getFavoriteId();
				m.addAttribute("fdishlist",dishlist);
				session.setAttribute("fdishlist",dishlist);
			}
			
			
			String date=processTime.getStringNowTimeWithDate();
			
			List<HistoryItem> historyItemlist=historyService.selectByUserId(u.getUserId());
			session.setAttribute("historyItemlist", historyItemlist);
			for(HistoryItem hi:historyItemlist)
				System.out.println(hi.getUserId()+" "+hi.getOrderId()+" "+hi.getDishId().getDishName());
			
			m.addAttribute("historyItemlist", historyItemlist);
			session.setAttribute("historyItemlist", historyItemlist);
			m.addAttribute("u", u);
		    m.addAttribute("date", date);
		    session.setAttribute("userphone", userphone);
		    
		    return "homePage";
			
		}
		
	}
}
