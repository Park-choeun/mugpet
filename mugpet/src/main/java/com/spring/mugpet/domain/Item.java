package com.spring.mugpet.domain;

public class Item {
	private int item_id;				//primary key
	private int category_id;			//item이 속한 category id
	private int spe_id;					//반려동물 종 id
	private String itemName;			//상품명
	private int price;					//가격
	private String brand;				//브랜드
	private String imgUrl;				//이미지 경로
	private String comments;			//상품 설명글
	private int filter;					//검색할 때 사용할 필터값

	public Item() {}

	public Item(int item_id, int category_id, int spe_id, String itemName, int price, String brand, String imgUrl,
			String comments, int filter) {
		this.item_id = item_id;
		this.category_id = category_id;
		this.spe_id = spe_id;
		this.itemName = itemName;
		this.price = price;
		this.brand = brand;
		this.imgUrl = imgUrl;
		this.comments = comments;
		this.filter = filter;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSpe_id() {
		return spe_id;
	}

	public void setSpe_id(int spe_id) {
		this.spe_id = spe_id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgURL(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getFilter() {
		return filter;
	}

	public void setFilter(int filter) {
		this.filter = filter;
	}
}