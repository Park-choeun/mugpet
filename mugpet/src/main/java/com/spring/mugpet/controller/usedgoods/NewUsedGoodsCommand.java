package com.spring.mugpet.controller.usedgoods;

import java.util.Date;

public class NewUsedGoodsCommand {
	
	private String imgUrl;
	private String title;
	private String content;
	private Date enroillDt;
	private int price;
	private int likes;
	private int replyCnt;
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getEnroillDt() {
		return enroillDt;
	}
	public void setEnroillDt(Date enroillDt) {
		this.enroillDt = enroillDt;
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
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
}
