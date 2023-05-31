package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Review;

public interface ReviewDao {
	
	Review getReview(int r_id) throws DataAccessException;
	
	List<Review> getItemReivewList(int item_id) throws DataAccessException;
	
	List<Review> getMyReviewList(int u_id) throws DataAccessException;
	
	void insertReview(Review review) throws DataAccessException;
	
	void updateReview(Review review) throws DataAccessException;
	
	void deleteReview(int r_id) throws DataAccessException;
}
