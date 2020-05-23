package com.niit.pojo;

import java.math.BigDecimal;

public class Dish {
    private Integer dishId;

    private Integer windowId;

    private String dishName;

    private BigDecimal dishPrice;

    private String dishDiscription;

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dish(Integer dishId, Integer windowId, String dishName, BigDecimal dishPrice, String dishDiscription) {
		super();
		this.dishId = dishId;
		this.windowId = windowId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishDiscription = dishDiscription;
	}

	public Integer getWindowId() {
        return windowId;
    }

    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDiscription() {
        return dishDiscription;
    }

    public void setDishDiscription(String dishDiscription) {
        this.dishDiscription = dishDiscription;
    }
}