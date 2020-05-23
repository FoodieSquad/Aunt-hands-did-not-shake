package com.niit.dao.test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.mapper.*;
import com.niit.pojo.*;
import com.niit.util.ProcessTime;

@RunWith(SpringJUnit4ClassRunner.class)
//加载classpath路径下（即src/main/resource目录下)
//srping文件夹中所有已application开头的文件，*代表任意字符。
@ContextConfiguration(locations="classpath:spring/application*.xml")
public class daotest {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private CanteenMapper canteenMapper;
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private CartItemMapper cartItemMapper;
	@Autowired
	private DeliverMapper deliverMapper;
	@Autowired
	private DishMapper dishMapper;
	@Autowired
	private FavoriteMapper favoriteMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WindowMapper windowMapper;
	@Autowired
	private UserAddressMapper userAddressMapper;
	@Autowired
	private UserTeleMapper userTeleMapper;
	
	private ProcessTime processTime=new ProcessTime();

	
//@Test
	public void TestcartItemMapper() {
		cartItemMapper.insert2(14, 10101, 2);
		
	}
	
	
  //  @Test
	public void TestAdmin() {
	Admin a=adminMapper.selectByPrimaryKey(1);
	System.out.println(a.getAdminName());
	
	
	}
 //@Test
    public void TestCanteen() {
//    	Canteen c=canteenMapper.selectByPrimaryKey(1);
//    	List<Canteen> list=canteenMapper.selectAll();
//    	System.out.println(c.getCanteenName());
    	
	 List<Canteen> list=canteenMapper.searchCanteenByName("海大第一");
	 for(Canteen m:list) {
 		System.out.println(m.getCanteenName());}
    }
    
//@Test 
    public void TestCart() {
	//cartMapper.insert(13);
    //cartMapper.deleteByPrimaryKey(13);
  	
//	List<Integer> testlist=new ArrayList<Integer>();
//	testlist.add(1);
//	testlist.add(1);
//	System.out.println(testlist.size());
	
  	


    }
    
   // @Test
    public void TestDeliver() {
    	Deliver d=deliverMapper.selectByPrimaryKey(1);
    	System.out.println(d.getDeliverName());
    	
    	List<Deliver> list=deliverMapper.selectAll();
    	for(Deliver de:list) {
    		System.out.println(de.getDeliverName());
    	}
    }
    
//@Test
    public void TestDish() {
    	//dishMapper.selectAll();
    	
    	List<Dish> list=dishMapper.searchByDishName("一");
    	for(Dish d:list) {
    		System.out.println(d.getDishId()+d.getDishName());
    	}
    }
//@Test
    public void TestFavourite() {
//    	List<Favorite> list=favoriteMapper.selectAll();
//    	
//    	for(Favorite f:list) {
//    		System.out.println(f.getFavoriteId()+f.getUserId());
//    	}
//
    	Favorite f=favoriteMapper.selectByUserId(1);
    	List<Dish> list=	f.getFavoriteId();
    	for(Dish d:list) {
    		System.out.println(d.getDishId()+d.getDishName());
    	}
    }
    
 //@Test
    public void TestOrder() {
	 //List<Order> list=orderMapper.selectAll();
   List<Order> list=orderMapper.selectByUserId(1);
	// java.sql.Date orderEndTime= new java.sql.Date(new Date().getTime());
	// Order o= orderMapper.selectByPrimaryKey(203, 1, 1);
	//o.setOrderStartTime(orderStartTime);
//	o.setOrderEndTime(orderEndTime);
//	 orderMapper.updateByPrimaryKey(o);
	 
//	 List<Order> list= orderMapper.selectByUserId(2);
 String s;
	 for(Order o:list) {
		s= processTime.getFormatDate(o.getOrderStartTime());
	    System.out.println(s);
	 }
//	 
//	 User u=userMapper.selectByPrimaryKey(1);
//	 int orderId=orderHelper.getOrderLatestIdByUserId(u.getUserId());
//	 Order o=new Order();
//	 o.setOrderStartTimeWithNowTime();
//	 o.setOrderId(orderId);
//	 o.setUserId(u.getUserId());
//	 o.setCartId(u.getUserId());
//	 
	   }
@Test 
    public void TestUser() {
	
//  List<User> Userlist= userMapper.selectAll();
//  User u=Userlist.get(0);
//User u=userMapper.selectByPrimaryKey(1);
//String name=u.getCartId().getCartItemId().get(0).getDishId().getDishName();
//System.out.println(name);
	// userMapper.updateByPrimaryKey(u);
//  Cart c=  u.getCartId();
//    List<Dish> list=  c.getDish_id();
//    for(Dish de:list) {
//		System.out.println(de.getDishId());
//	}
//  List<UserAddress> UserAddresslist= u.getUserAddress();
//  for(UserAddress ua:UserAddresslist) {
//	 
//	  System.out.println( ua.getUserAddress());
//  }
//  
//  List<UserTele> UserTelelist= u.getUserTele();
//  for(UserTele ut:UserTelelist) {
//	System.out.println( ut.getUserTele());
//  } 
 // userMapper.deleteByPrimaryKey(10);
 
  
  
//  
    	}
  
//@Test
  public void TestAddress() {
//TestUser();
// List<UserAddress> UserAddresslist


//userAddressMapper.insert(userAddress);
List<UserAddress> UserAddresslist=userAddressMapper.selectByUserId(1);
for(UserAddress ua:UserAddresslist) {
	System.out.println(ua.getUserAddressId()+ua.getUserAddress());
}
UserAddress userAddress=new UserAddress(1, "海南大学小吃城");
userAddressMapper.insert(userAddress);
UserAddresslist=userAddressMapper.selectByUserId(1);
for(UserAddress ua:UserAddresslist) {
	System.out.println(ua.getUserAddressId()+ua.getUserAddress());
}
//UserAddress userAddress=userAddressMapper.selectByPrimaryKey(13, 9);
//userAddress.setUserAddress("海南大学9栋");
//userAddressMapper.updateByPrimaryKey(userAddress);

//TestUser();
  }
 //@Test
  public void TestUserTele() {
	 UserTele  ut=userTeleMapper.selectUserIdByUserTele("666666666");
	 System.out.println(ut.getUserId()+"  "+ut.getUserTele()+"  "+ut.getUserTeleId());
	  //UserTeleMapper
	 // UserTeleMapper.deleteByPrimaryKey(@Param("userAddressId") Integer userAddressId, @Param("userId") Integer userId);

	//UserTeleMapper.insert(UserAddress record);

	 // UserTele  ut= userTeleMapper.selectByPrimaryKey(@Param("userAddressId") Integer userAddressId, @Param("userId") Integer userId);

	    //List<UserTele>   UserTeleMapper. selectAll();
//	    
//	  List<UserTele> UserTelelist = userTeleMapper.selectByUserId(2);
//	  for(UserTele ut:UserTelelist) {
//			System.out.println(ut.getUserId()+"  "+ut.getUserTele()+"  "+ut.getUserTeleId());
//		}
	//  UserTele ut2=new UserTele(null, 2, "123456789");
//	  UserTele ut2=  userTeleMapper.selectByPrimaryKey(22, 2);
//	  ut2.setUserTele("987654331");
//	 userTeleMapper.updateByPrimaryKey(ut2);
	 // userTeleMapper.insert(ut2);
//	  List<UserTele> UserTelelist2 = userTeleMapper.selectByUserId(2);
//	  for(UserTele ut:UserTelelist2) {
//			System.out.println(ut.getUserId()+"  "+ut.getUserTele()+"  "+ut.getUserTeleId());
//		}
//	    //int   UserTeleMapper.updateByPrimaryKey(UserAddress record);  
	 
  }  
  
 //@Test
 public void TestWindow() {
	 windowMapper.selectAll();
	 windowMapper.selectByCanteenId(1);
	 windowMapper.selectByPrimaryKey(101);
	 dishMapper.selectByWindowId(101);
	 
 }
    
    
    
    
	
}