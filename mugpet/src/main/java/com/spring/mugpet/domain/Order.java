package com.spring.mugpet.domain;

public class Order {
	private int o_id;		//primary key
	private int item_id;	//구매한 item의 id
	private int buyQty;		//구매하는 개수
	private int u_id;		//로그인한 사용자 id
	
	public Order() {}

	public Order(int o_id, int item_id, int buyQty, int u_id) {
		this.o_id = o_id;
		this.item_id = item_id;
		this.buyQty = buyQty;
		this.u_id = u_id;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getBuyQty() {
		return buyQty;
	}

	public void setBuyQty(int buyQty) {
		this.buyQty = buyQty;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}
