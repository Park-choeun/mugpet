package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mugpet.dao.OrderItemDao;
import com.spring.mugpet.domain.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;
	//member의 주문 아이템 목록 가져오기
	public OrderItem getOrderItemList(int o_id){
		return orderItemDao.getOrderItemList(o_id);
	}

	//member의 모든 주문 아이템 목록 가져오기
	public List<OrderItem> getAllOrderItemList(int u_id){
		return orderItemDao.getAllOrderItemList(u_id);
	}

	@Override
	public int getOrderItemCnt(int u_id) {
		return orderItemDao.getOrderItemCnt(u_id);
	}

	@Override
	public boolean isCheckOrderItem(int u_id, int item_id) {
		if(orderItemDao.isCheckOrderItem(u_id,item_id) != null)
			return true; 
		else return false;
	}
}