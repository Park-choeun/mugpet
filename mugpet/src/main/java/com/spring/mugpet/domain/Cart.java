package com.spring.mugpet.domain;

public class Cart {
	
	private int cart_id;
	private Item item;
	private int total;
	private int cartQty;
	private int u_id;
	
	
	
	
	public Cart() {}


	public Cart(int cart_id, Item item, int total, int cartQty, int u_id) {
		super();
		this.cart_id = cart_id;
		this.item = item;
		this.total = total;
		this.cartQty = cartQty;
		this.u_id = u_id;
	}
	
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCartQty() {
		return cartQty;
	}
	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	
	
	

}
