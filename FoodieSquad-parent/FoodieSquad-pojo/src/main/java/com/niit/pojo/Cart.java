package com.niit.pojo;

import java.util.List;

public class Cart {
    private Integer cartId;

    public List<CartItem> getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(List<CartItem> cartItemId) {
		this.cartItemId = cartItemId;
	}

	private List<CartItem> cartItemId;

    
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

	public Cart(Integer cartId, List<CartItem> cartItemId) {
		super();
		this.cartId = cartId;
		this.cartItemId = cartItemId;
	}

	

   
}