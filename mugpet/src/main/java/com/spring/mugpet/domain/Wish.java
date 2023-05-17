package com.spring.mugpet.domain;

public class Wish {
	private int w_id;		//primary key
	private int item_id;	//wish에 담은 item의 id
	private boolean want;	//wish에 담겨있으면 true, 삭제하려면 false
	private int u_id;		//로그인한 사용자 id
	
	public Wish() {}

	public Wish(int w_id, int item_id, boolean want, int u_id) {
		this.w_id = w_id;
		this.item_id = item_id;
		this.want = want;
		this.u_id = u_id;
	}

	public int getW_id() { return w_id; }
	public void setW_id(int w_id) { this.w_id = w_id; }

	public int getItem_id() { return item_id; }
	public void setItem_id(int item_id) { this.item_id = item_id; }

	public boolean isWant() { return want; }
	public void setWant(boolean want) { this.want = want; }

	public int getU_id() { return u_id; }
	public void setU_id(int u_id) { this.u_id = u_id; }
}
