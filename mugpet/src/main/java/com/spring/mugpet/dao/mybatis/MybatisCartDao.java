package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.CartDao;
import com.spring.mugpet.dao.mybatis.mapper.CartMapper;
import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;

@Repository
public class MybatisCartDao implements CartDao{
	
	@Autowired
	private CartMapper cartMapper;
	
	//Cart 목록 리스트 형태로 가져오기 (장바구니는 하나)
	public List<Cart> getMyCartList(int u_id) throws DataAccessException{
		return cartMapper.getMyCartList(u_id);
	}
	//Cart 목록에 있는 카트 필드 정보 가져오기
	public int getMyCartItemQty(int item_id) throws DataAccessException{
		return cartMapper.getMyCartItemQty(item_id);
	}
	//Cart 목록에 있는 하나의 아이템 정보 가져오기
	public Item getCartItemInfo(int item_id) throws DataAccessException{
		return cartMapper.getCartItemInfo(item_id);
	}
	//Cart 목록에 있는 하나의 아이템 정보를 Cart 타입으로 가져오기
	public Cart getMyCartItemCartType(int item_id) throws DataAccessException{
		return cartMapper.getMyCartItemCartType(item_id);
	}
	
	//Cart 목록에 item 추가하기
	public void addCart(Item item) throws DataAccessException{
		cartMapper.addCart(item);
	}

	//Cart 목록에 item 정보 수정하기
	public void updateCart(int cartQty, int item_id) throws DataAccessException{
		cartMapper.updateCart(cartQty, item_id);
	}

	//Cart 목록에 item 삭제하기
	public void removeCart(int item_id) throws DataAccessException{
		cartMapper.removeCart(item_id);
	}
}
