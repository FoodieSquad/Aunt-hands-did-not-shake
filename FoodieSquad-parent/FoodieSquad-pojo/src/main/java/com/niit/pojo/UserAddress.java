package com.niit.pojo;

public class UserAddress {
    public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(Integer userId, String userAddress) {
		super();
		
		this.userAddressId = null;
		this.userId = userId;
		this.userAddress = userAddress;
	}

	private Integer userAddressId;

    private Integer userId;

    private String userAddress;

    public Integer getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Integer userAddressId) {
        this.userAddressId = userAddressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}