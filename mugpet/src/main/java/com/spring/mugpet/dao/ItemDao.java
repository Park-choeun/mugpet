package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;

public interface ItemDao {
	
	Item getItem(int item_id) throws DataAccessException;
	
	List<Item> getALLItemList(int spe_id) throws DataAccessException;
	
	List<Item> getItemList(int spe_id, int category_id) throws DataAccessException;
	
	List<Item> getSearchItemList(int spe_id, int filter) throws DataAccessException;
	
	List<Item> orderByItem(int spe_id, String standard, String od) throws DataAccessException;
	
	void insertItem(Item item) throws DataAccessException;
	
	void updateItem(Item item) throws DataAccessException;
	
	void deleteItem(int item_id) throws DataAccessException;
}
