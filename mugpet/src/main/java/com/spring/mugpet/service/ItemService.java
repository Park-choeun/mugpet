package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.domain.Item;

public interface ItemService {
	
	Item getItem(int item_id);
	
	List<Item> getALLItemList(int spe_id);
	
	List<Item> getItemList(int spe_id, int category_id);
	
	List<Item> getSearchItemList(int spe_id, int filter);
	
	List<Item> orderByItem(int spe_id, String stand, String od);
	
	void insertItem(Item item);
	
	void updateItem(Item item);
	
	void deleteItem(int item_id);
}
