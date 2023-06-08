package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mugpet.dao.ItemDao;
import com.spring.mugpet.domain.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public Item getItem(int item_id) {
		return itemDao.getItem(item_id);
	}

	@Override
	public List<Item> getALLItemList(int spe_id) {
		return itemDao.getALLItemList(spe_id);
	}

	@Override
	public List<Item> getItemList(int spe_id, int category_id) {
		return itemDao.getItemList(spe_id, category_id);
	}

	@Override
	public List<Item> getFilterItemList(int spe_id, int age, String stuff, String feature) {
		return itemDao.getFilterItemList(spe_id, age, stuff, feature);
	}

	@Override
	public List<Item> orderByALLItem(int spe_id, String stand, String od) {
		return itemDao.orderByALLItem(spe_id, stand, od);
	}
	
	@Override
	public List<Item> orderByCategoryItem(int spe_id, int category_id, String stand, String od) {
		return itemDao.orderByCategoryItem(spe_id, category_id, stand, od);
	}

	@Override
	public void insertItem(Item item) {
		itemDao.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	@Override
	public void deleteItem(int item_id) {
		itemDao.deleteItem(item_id);
	}
}
