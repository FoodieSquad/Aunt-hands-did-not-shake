package com.niit.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer userId;

    private Integer cartId;

    private Date orderStartTime;

    private Date orderEndTime;

    public Order(Integer orderId, Integer userId, Integer cartId, Date orderStartTime, Date orderEndTime,
			String orderType, Date orderArriveTime, String orderAddress, Integer deliverId, BigDecimal orderPrice,
			String orderPayType) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.cartId = cartId;
		this.orderStartTime = orderStartTime;
		this.orderEndTime = orderEndTime;
		this.orderType = orderType;
		this.orderArriveTime = orderArriveTime;
		this.orderAddress = orderAddress;
		this.deliverId = deliverId;
		this.orderPrice = orderPrice;
		this.orderPayType = orderPayType;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	private String orderType;

    private Date orderArriveTime;

    private String orderAddress;

    private Integer deliverId;

    private BigDecimal orderPrice;

    private String orderPayType;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Date getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }
    
    public void setOrderStartTimeWithNowTime() {
    java.sql.Date nowTime= new java.sql.Date(new Date().getTime());
    this.orderStartTime = nowTime;
    }
    
    public void setOrderEndTimeWithNowTime() {
        java.sql.Date nowTime= new java.sql.Date(new Date().getTime());
        this.orderEndTime = nowTime;
        }
    public void setOrderArriveTimeWithNowTime() {
        java.sql.Date nowTime= new java.sql.Date(new Date().getTime());
        this.orderArriveTime = nowTime;
        }


    public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getOrderArriveTime() {
        return orderArriveTime;
    }

    public void setOrderArriveTime(Date orderArriveTime) {
        this.orderArriveTime = orderArriveTime;
    }

   

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType;
    }
}