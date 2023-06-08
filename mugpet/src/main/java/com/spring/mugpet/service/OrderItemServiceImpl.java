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
	public List<OrderItem> getOrderItemList(int o_id){
		return orderItemDao.getOrderItemList(o_id);
	}

	//member의 모든 주문 아이템 목록 가져오기
	public List<OrderItem> getAllOrderItemList(int u_id){
		return orderItemDao.getAllOrderItemList(u_id);
	}
	
	//주문 목록에 상품 추가하기	
	public void insertOrderItem(OrderItem orderItem) {
		orderItemDao.insertOrderItem(orderItem);
	}
	
	//주문 목록에 상품 수정하기
	public void updateOrderItem(OrderItem orderItem) {
		orderItemDao.updateOrderItem(orderItem);
	}
	
	//주문 목록에 상품 삭제하기
	public void deleteOrderItem(OrderItem orderItem) {
		orderItemDao.deleteOrderItem(orderItem);
	}
}
