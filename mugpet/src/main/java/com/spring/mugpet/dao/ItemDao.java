package com.spring.mugpet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;

public interface ItemDao {
	
	Item getItem(int item_id) throws DataAccessException;
	
	List<Item> getALLItemList(int spe_id) throws DataAccessException;
	
	List<Item> getItemList(int spe_id, int category_id) throws DataAccessException;
	
	List<Item> getFilterItemList(Map<String, Object> param) throws DataAccessException;
	
	List<Item> orderByItem(int spe_id, int category_id, String stand, String od) throws DataAccessException;
	
	void insertItem(Item item) throws DataAccessException;
	
	void updateWish(int wish, int item_id) throws DataAccessException;
	
	void updateItem(Item item) throws DataAccessException;
	
	void deleteItem(int item_id) throws DataAccessException;
}
