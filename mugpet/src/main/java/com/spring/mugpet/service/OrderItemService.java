package com.spring.mugpet.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.OrderItem;

public interface OrderItemService {
	//member의 주문 아이템 목록 가져오기
	OrderItem getOrderItemList(int o_id); 

	//member의 모든 주문 아이템 목록 가져오기
	List<OrderItem> getAllOrderItemList(int u_id);
	
}
