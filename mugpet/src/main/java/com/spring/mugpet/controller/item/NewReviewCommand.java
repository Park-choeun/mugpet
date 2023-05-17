package com.spring.mugpet.controller.item;

public class NewReviewCommand {
	
	private String review;
	private int item_id;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
}