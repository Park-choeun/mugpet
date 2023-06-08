package com.spring.mugpet.domain;

public class OrderItem {
	private int o_id;			//primary key
	private int item_id;		//구매한 item의 id
	private int orderQty;		//구매하는 개수
	private String orderAddr;		//배송지
	private String orderPhoneNum; 	//전화번호
	private int u_id;			//로그인한 사용자 id
	
	public OrderItem() {}

	public OrderItem(int o_id, int item_id, int orderQty, int u_id) {
		this.o_id = o_id;
		this.item_id = item_id;
		this.orderQty = orderQty;
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

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getOrderPhoneNum() {
		return orderPhoneNum;
	}

	public void setOrderPhoneNum(String orderPhoneNum) {
		this.orderPhoneNum = orderPhoneNum;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}
