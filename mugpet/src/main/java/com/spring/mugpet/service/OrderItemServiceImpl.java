package com.spring.mugpet.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.mugpet.dao.OrderItemDao;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;
	//member의 주문 아이템 목록 가져오기
	public List<OrderItem> getOrderItemList(int u_id, String orderTime){
		return orderItemDao.getOrderItemList(u_id, orderTime);
	}

	//member의 모든 주문 아이템 목록 가져오기
	public List<String> getAllOrderTimeList(int u_id){
		return orderItemDao.getAllOrderTimeList(u_id);
	}
	
	//주문 목록에 있는 하나의 아이템 정보 가져오기 (상품명, 가격 등)
	public Item getOrderItemInfo(int item_id) {
		return orderItemDao.getOrderItemInfo(item_id);
	}
	
	public List<OrderItemInfos> getAllOrderItemList(int u_id, String orderTime) {
		return orderItemDao.getAllOrderItemList(u_id, orderTime);
	}
	//주문 목록에 상품 추가하기	
	public void insertOrderItem(OrderItem orderItem) {
		orderItemDao.insertOrderItem(orderItem);
	}
		
	//주문 목록 삭제하기
	public void deleteOrderItem(int u_id, String orderTime) {
		orderItemDao.deleteOrderItem(u_id, orderTime);
	}
}