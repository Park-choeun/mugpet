package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;

public interface WishDao {

	List<Item> getMyWishList(int u_id) throws DataAccessException;
	
	Integer isWish(int item_id, int u_id) throws DataAccessException;

	void insertWish(int item_id, int u_id) throws DataAccessException;
	
	void deleteWish(int item_id, int u_id) throws DataAccessException;

	List<Item> getMyWishListForMyHome(int u_id) throws DataAccessException;
}
