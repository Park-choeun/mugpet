package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.ItemDao;
import com.spring.mugpet.dao.mybatis.mapper.ItemMapper;
import com.spring.mugpet.domain.Item;

@Repository
public class MybatisItemDao implements ItemDao {

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public Item getItem(int item_id) throws DataAccessException {
		return itemMapper.getItem(item_id);
	}

	@Override
	public List<Item> getALLItemList(int spe_id) throws DataAccessException {
		return itemMapper.getALLItemList(spe_id);
	}

	@Override
	public List<Item> getItemList(int spe_id, int category_id) throws DataAccessException {
		return itemMapper.getItemList(spe_id, category_id);
	}

	@Override
	public List<Item> getSearchItemList(int spe_id, int filter) throws DataAccessException {
		return itemMapper.getSearchItemList(spe_id, filter);
	}

	@Override
	public List<Item> orderByItem(int spe_id, String stand, String od) throws DataAccessException {
		return itemMapper.orderByItem(spe_id, stand, od);
	}

	@Override
	public void insertItem(Item item) throws DataAccessException {
		itemMapper.insertItem(item);
		
	}

	@Override
	public void updateItem(Item item) throws DataAccessException {
		itemMapper.updateItem(item);
	}

	@Override
	public void deleteItem(int item_id) throws DataAccessException {
		itemMapper.deleteItem(item_id);
	}
}
