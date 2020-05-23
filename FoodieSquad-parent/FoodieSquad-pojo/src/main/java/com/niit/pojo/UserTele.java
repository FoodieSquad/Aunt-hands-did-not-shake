package com.niit.pojo;

public class UserTele {
    public UserTele() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTele( Integer userId, String userTele) {
		super();
		this.userTeleId = null;
		this.userId = userId;
		this.userTele = userTele;
	}

	private Integer userTeleId;

    private Integer userId;

    private String userTele;

    public Integer getUserTeleId() {
        return userTeleId;
    }

    public void setUserTeleId(Integer userTeleId) {
        this.userTeleId = userTeleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserTele() {
        return userTele;
    }

    public void setUserTele(String userTele) {
        this.userTele = userTele;
    }
}