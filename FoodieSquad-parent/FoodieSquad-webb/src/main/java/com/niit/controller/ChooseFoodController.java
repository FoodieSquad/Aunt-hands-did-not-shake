package com.niit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.pojo.Canteen;
import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.Dish;
import com.niit.pojo.User;
import com.niit.pojo.Window;
import com.niit.service.CanteenService;
import com.niit.service.CartService;
import com.niit.service.DishService;
import com.niit.service.WindowService;
@SessionAttributes(value= {"orderType"})
@Controller
@RequestMapping("/chooseFood")
public class ChooseFoodController {
	@Autowired
	private WindowService windowService;
	@Autowired 
	private CanteenService canteenService;	
	@Autowired
	private DishService dishService;
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/test.do")
	public ModelAndView test(@Param("canteenId") Integer canteenId,@Param("orderType") String orderType,Model model) {
		
		System.out.println("orderType"+orderType);
		model.addAttribute("orderType", orderType);
		System.out.println("response calling");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("chooseFoodPage");
		Canteen canteen=canteenService.selectByPrimaryKey(canteenId);
		mv.addObject("canteenName", canteen.getCanteenName());
		List<Window> windowList=windowService.selectByCanteenId(canteenId);
		mv.addObject("windowList", windowList);
		List<List<Dish>> dishListList=new ArrayList<List<Dish>>();
		int i=0;
		for(Window win: windowList)
		{
			List<Dish> dishList=dishService.selectByWindowId(win.getWindowId());
			dishListList.add(dishList);
			i++;
		}
		mv.addObject("dishListList", dishListList);
		return mv;
	}
	
//	@RequestMapping("/submit.do")
//	public ModelAndView submit(@RequestParam("menu") List<String> menu) {
//		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("hello");
//		for(String str:menu)
//		{
//			System.out.println(str);
//		}
//		List<CartItem> cartItemId=new ArrayList<CartItem>();
//		
//		for(int i=0;i<menu.size();)
//		{
//			Integer dish_id=Integer.parseInt(menu.get(i));
//			Integer dish_count=Integer.parseInt(menu.get(i+1));
//			Dish dish=dishService.selectByPrimaryKey(dish_id);
//			CartItem cartItem=new CartItem();
//			cartItem.setDishCount(dish_count);
//			cartItem.setDishId(dish);
//			cartItemId.add(cartItem);
//			i+=2;
//		}
//		Cart record=new Cart();
//		record.setCartItemId(cartItemId);
//		cartService.insert(record);
//		return mv;
//	}
	
	
	@RequestMapping("/submit.do")
	public void submit(@RequestParam("menu") List<String> menu,HttpServletRequest request , HttpServletResponse response,HttpSession session) {
		//Integer userId=(Integer)request.getAttribute("userId");
	      User u=(User)session.getAttribute("u");
	      int cartId=u.getUserId();
		String orderType=request.getParameter("orderType");
		
		request.setAttribute("orderType", orderType);
		
		
		for(String str:menu)
		{
			System.out.println("menu:菜单："+str);
		}
		List<CartItem> cartItemId=new ArrayList<CartItem>();
		
		for(int i=0;i<menu.size();)
		{
			Integer dish_id=Integer.parseInt(menu.get(i));
			Integer dish_count=Integer.parseInt(menu.get(i+1));
			System.out.println("cartService.insertOneItem("+cartId+","+ dish_id+","+dish_count+";");
		
		    cartService.insertOneItem(cartId, dish_id, dish_count);
			i+=2;
		}
		
		
		try {
			request.getRequestDispatcher("../submitOrder/test.do").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
