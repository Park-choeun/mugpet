package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.mugpet.dao.WishDao;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.Wish;

@Service
public class WishServiceImpl implements WishService{
	
	@Autowired
	private WishDao wishDao;
	
	//member의 wish 목록을 리스트 형태로 가져오기
	public List<Wish> getWishList(int u_id){
		return wishDao.getWishList(u_id);
	}
	
	//Wish 목록에 있는 하나의 아이템 정보 가져오기
	public Item getWishItemInfo(int item_id) {
		return wishDao.getWishItemInfo(item_id);
	}
}
