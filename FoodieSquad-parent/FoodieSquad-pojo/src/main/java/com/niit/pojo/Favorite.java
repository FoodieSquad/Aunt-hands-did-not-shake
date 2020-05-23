package com.niit.pojo;

import java.util.List;

public class Favorite {
   
	public List<Dish> getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(List<Dish> favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(List<Dish> favoriteId, Integer userId) {
		super();
		this.favoriteId = favoriteId;
		this.userId = userId;
	}

	private List<Dish> favoriteId;//一堆菜id

    private Integer userId;//一个用户id

  

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}