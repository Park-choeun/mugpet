package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import com.spring.mugpet.domain.Item;

public interface ItemMapper {
	
	//하나의 상품정보 가져오기
	Item getItem(int item_id);
		
	//각 카테고리에 해당하는 상품목록가져오기
	List<Item> getItemList(int category_id);
		
	//상품 전체목록 가져오기
	List<Item> getALLItemList();
		
	//필터링(검색)한 상품정보목록 가져오기
	List<Item> getSearchItemList(int filter);
		
	//상품 추가하기
	void insertItem(Item item);
		
	//상품정보 수정하기
	void updateItem(Item item);
		
	//상품 삭제하기
	void deleteItem(int item_id);
}