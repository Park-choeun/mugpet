package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

public interface CartDao {
	
	//Cart 목록 리스트 형태로 가져오기 (장바구니는 하나)
	List<Cart> getMyCartList(int u_id) throws DataAccessException;
	
	//Cart 목록에 있는 카트 필드 정보 가져오기
	int getMyCartItemQty(int item_id) throws DataAccessException;
	
	//Cart 목록에 있는 하나의 아이템 정보 가져오기 (상품명, 가격 등)
	Item getCartItemInfo(int item_id) throws DataAccessException;
	
	//Cart 목록에 있는 하나의 아이템 정보를 Cart 타입으로 가져오기
	Cart getMyCartItemCartType(int item_id) throws DataAccessException;
	
	//Cart 목록에 item 추가하기
	void addCart(Item item) throws DataAccessException; 

	//Cart 목록에 item 정보 수정하기
	void updateCart(int cartQty, int item_id) throws DataAccessException; 

	//Cart 목록에 item 삭제하기
	void removeCart(int item_id) throws DataAccessException; 
}
