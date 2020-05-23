package com.niit.pojo;

public class CartItem {
    private Integer cartItemId;

    private Integer cartId;

    private Dish dishId;

    public Dish getDishId() {
		return dishId;
	}

	public CartItem(Integer cartId, Dish dishId, Integer dishCount) {
		super();
		this.cartId = cartId;
		this.dishId = dishId;
		this.dishCount = dishCount;
	}

	public void setDishId(Dish dishId) {
		this.dishId = dishId;
	}

	private Integer dishCount;

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

  

    public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDishCount() {
        return dishCount;
    }

    public void setDishCount(Integer dishCount) {
        this.dishCount = dishCount;
    }
}