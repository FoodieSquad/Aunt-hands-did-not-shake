package com.niit.pojo;

import java.math.BigDecimal;
import java.util.List;

public class User {


	private Integer userId;

    private String userStudentNum;

    private String userName;

    private String userPassword;

    private List<UserTele> userTele;

    private String userGender;

    private List<UserAddress> userAddress;

    private BigDecimal userBalance;

    private Integer userType;

    private Cart cartId;
    
    public Cart getCartId() {
		return cartId;
	}



	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}



	public Integer getUserId() {
        return userId;
    }

   

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userStudentNum, String userName, String userPassword, List<UserTele> userTele,
			String userGender, List<UserAddress> userAddress, BigDecimal userBalance, Integer userType) {
		super();
		this.userId = null;
		this.userStudentNum = userStudentNum;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTele = userTele;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userBalance = userBalance;
		this.userType = userType;
		this.cartId =null;
	}



	public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserStudentNum() {
        return userStudentNum;
    }

    public void setUserStudentNum(String userStudentNum) {
        this.userStudentNum = userStudentNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

   

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

   




	public List<UserTele> getUserTele() {
		return userTele;
	}



	public void setUserTele(List<UserTele> userTele) {
		this.userTele = userTele;
	}



	public List<UserAddress> getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}



}