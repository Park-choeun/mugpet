package domain;

import java.util.Date;

public class UsedGoods {
	private int g_id;
	private int imageURL;
	private String title;
	private Date enrollDt;
	private int price;
	private int likes;
	private int chatCnt;
	private int u_id;
	
	public UsedGoods() {
		
	}
	
	public UsedGoods(int g_id, int imageURL, String title, Date enrollDt, int price, int likes, int chatCnt, int u_id) {
		super();
		this.g_id = g_id;
		this.imageURL = imageURL;
		this.title = title;
		this.enrollDt = enrollDt;
		this.price = price;
		this.likes = likes;
		this.chatCnt = chatCnt;
		this.u_id = u_id;
	}

	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public int getImageURL() {
		return imageURL;
	}
	public void setImageURL(int imageURL) {
		this.imageURL = imageURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getChatCnt() {
		return chatCnt;
	}
	public void setChatCnt(int chatCnt) {
		this.chatCnt = chatCnt;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}
