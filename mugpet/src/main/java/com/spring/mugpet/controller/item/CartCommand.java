package com.spring.mugpet.controller.item;

import java.util.List;

import com.spring.mugpet.domain.Cart;

public class CartCommand {
	private List<Cart> cartItems;

	protected List<Cart> getCartItems() {
		return cartItems;
	}

	protected void setCartItems(List<Cart> cartItems) {
		this.cartItems = cartItems;
	}
}
