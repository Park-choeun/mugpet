package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mugpet.dao.WishDao;
import com.spring.mugpet.domain.Item;

@Service
@Transactional
public class WishServiceImpl implements WishService {
	
	@Autowired
	private WishDao wishDao;

	public List<Item> getMyWishList(int u_id) {
		return wishDao.getMyWishList(u_id);
	}
	
	public int isWish(int u_id, int item_id) {
		List<Integer> isWishList = wishDao.isWish(u_id);
		if (!isWishList.isEmpty()) {
			for (int i = 0; i < isWishList.size(); i++) {
				if (isWishList.get(i) == item_id) {
					return 1;
				}
			}
			return 0;
		} else {
			return 0;
		}
	}

	public void insertWish(int item_id, int u_id) {
		int isWish = isWish(u_id, item_id);
		if (isWish == 0) {
			wishDao.insertWish(item_id, u_id);
		}
	}

	public void deleteWish(int item_id, int u_id) {
		int isWish = isWish(u_id, item_id);
		if (isWish == 1) {
			wishDao.deleteWish(item_id, u_id);
		}
	}

}
