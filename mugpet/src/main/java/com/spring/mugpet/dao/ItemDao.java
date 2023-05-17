package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;

public interface ItemDao {
	
	//하나의 상품정보 가져오기
	Item getItem(int item_id) throws DataAccessException;
	
	//각 카테고리에 해당하는 상품목록가져오기
	List<Item> getItemList(int category_id) throws DataAccessException;
	
	//상품 전체목록 가져오기
	List<Item> getALLItemList() throws DataAccessException;
	
	//필터링(검색)한 상품정보목록 가져오기
	List<Item> getSearchItemList(int filter) throws DataAccessException;
	
	//상품 추가하기
	void insertItem(Item item) throws DataAccessException;
	
	//상품정보 수정하기
	void updateItem(Item item) throws DataAccessException;
	
	//상품 삭제하기
	void deleteItem(int item_id) throws DataAccessException;
}
