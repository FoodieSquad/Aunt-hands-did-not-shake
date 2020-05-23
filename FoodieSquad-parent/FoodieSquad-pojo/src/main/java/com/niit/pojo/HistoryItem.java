package com.niit.pojo;

public class HistoryItem {
    private Integer historyItemId;

    private Integer userId;

    private Integer orderId;

    public Dish getDishId() {
		return dishId;
	}

	public void setDishId(Dish dishId) {
		this.dishId = dishId;
	}

	private Dish dishId;

    public Integer getHistoryItemId() {
        return historyItemId;
    }

    public HistoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setHistoryItemId(Integer historyItemId) {
        this.historyItemId = historyItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

	public HistoryItem(Integer userId, Integer orderId, Dish dishId) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.dishId = dishId;
	}
    
    
    

   
}