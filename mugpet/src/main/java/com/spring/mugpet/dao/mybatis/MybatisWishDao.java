package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.WishDao;
import com.spring.mugpet.dao.mybatis.mapper.WishMapper;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.Wish;

@Repository
public class MybatisWishDao implements WishDao {

	@Autowired
	private WishMapper wishMapper;
	
	//member의 wish 목록을 리스트 형태로 가져오기
	public List<Wish> getWishList(int u_id) throws DataAccessException{
		return wishMapper.getWishList(u_id);
	}

	//Wish 목록에 있는 하나의 아이템 정보 가져오기
	public Item getWishItemInfo(int item_id) throws DataAccessException{
		return wishMapper.getWishItemInfo(item_id);
	}
	
	//Wish 목록에 item 추가하기
	public void insertWish(Wish wish) throws DataAccessException{
		wishMapper.insertWish(wish);
	}

	//Wish 목록에 item 삭제하기
	public void deleteWish(int item_id) throws DataAccessException{
		wishMapper.deleteWish(item_id);
	}
}
