package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.Wish;

public interface WishDao {
	
	//member의 wish 목록을 리스트 형태로 가져오기
	List<Wish> getWishList(int u_id) throws DataAccessException;

	//Wish 목록에 있는 하나의 아이템 정보 가져오기
	Item getWishItemInfo(int item_id) throws DataAccessException;
	
	//Wish 목록에 item 추가하기
	void insertWish(Item item) throws DataAccessException; 

	//Wish 목록에 item 삭제하기
	void deleteWish(int item_id) throws DataAccessException;
}
