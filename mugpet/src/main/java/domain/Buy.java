package domain;

public class Buy {
	private int buy_id;		//primary key
	private int item_id;	//구매한 item의 id
	private int r_id;		//Review객체 대신 id 활용
	private int buyQty;		//구매하는 개수
	private int u_id;
	
//	public Buy() {}

	public Buy(int buy_id, int item_id, int r_id, int buyQty, int u_id) {
		this.buy_id = buy_id;
		this.item_id = item_id;
		this.r_id = r_id;
		this.buyQty = buyQty;
		this.u_id = u_id;
	}

	public int getBuy_id() { return buy_id; }
	public void setBuy_id(int buy_id) { this.buy_id = buy_id; }

	public int getItem_id() { return item_id; }
	public void setItem_id(int item_id) { this.item_id = item_id; }

	public int getR_id() { return r_id; }
	public void setR_id(int r_id) { this.r_id = r_id; }

	public int getBuyQty() { return buyQty; }
	public void setBuyQty(int buyQty) { this.buyQty = buyQty; }

	public int getU_id() { return u_id; }
	public void setU_id(int u_id) { this.u_id = u_id; }
}
