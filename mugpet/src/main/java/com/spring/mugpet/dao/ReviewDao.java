package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Review;

public interface ReviewDao {
	
	//하나의 리뷰 불러오기
	Review getReview(int r_id) throws DataAccessException;
	
	//본인이 작성한 리뷰목록 불러오기
	List<Review> getMyReviewList(int u_id) throws DataAccessException;
	
	//리뷰 추가(작성)하기
	void insertReview(Review review) throws DataAccessException;
	
	//리뷰 수정하기
	void updateReview(Review review) throws DataAccessException;
	
	//리뷰 삭제하기
	void deleteReview(int r_id) throws DataAccessException;
}
