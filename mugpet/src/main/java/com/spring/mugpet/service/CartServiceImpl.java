package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.mugpet.dao.CartDao;
import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	//u_id 가지고 올 필요 없음. 여기서는 controller에서 u_id를 받아서 cart 정보 넘겨줌
	
	//Cart 목록 리스트 형태로 가져오기 (장바구니는 하나)
	public List<Cart> getMyCartList(int u_id){
		return cartDao.getMyCartList(u_id);
	}
	//Cart 목록에 있는 카트 필드 정보 가져오기
	public int getMyCartItemQty(int item_id) {
		return cartDao.getMyCartItemQty(item_id);
	}
	//Cart 목록에 있는 하나의 아이템 정보 가져오기
	public Item getCartItemInfo(int item_id) {
		return cartDao.getCartItemInfo(item_id);
	}
		
	//Cart 목록에 있는 하나의 아이템 정보를 Cart 타입으로 가져오기
	public Cart getMyCartItemCartType(int item_id) {
		return cartDao.getMyCartItemCartType(item_id);
	}
	
	//Cart 목록에 item 추가하기
	public void addCart(Item item) {
		cartDao.addCart(item);
	}
	
	//Cart 목록에 item 정보 수정하기
	public void updateCart(int cartQty, int item_id) {
		cartDao.updateCart(cartQty, item_id);
	}

	//Cart 목록에 item 삭제하기
	public void removeCart(int item_id) {
		cartDao.removeCart(item_id);
	}
	
}
