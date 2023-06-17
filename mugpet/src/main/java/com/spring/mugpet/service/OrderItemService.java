package com.spring.mugpet.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

public interface OrderItemService {
	//member의 주문 아이템 목록 가져오기
	List<OrderItem> getOrderItemList(int u_id, String orderTime); 

	//member의 모든 주문 아이템 목록 가져오기
	List<String> getAllOrderTimeList(int u_id);
	
	//주문 목록에 있는 하나의 아이템 정보 가져오기 (상품명, 가격 등)
	Item getOrderItemInfo(int item_id);
	
	List<OrderItemInfos> getAllOrderItemList(int u_id, String orderTime);
	
	//주문 목록에 상품 추가하기	
	void insertOrderItem(OrderItem orderItem);
	
	//주문 목록 삭제하기
	void deleteOrderItem(int u_id, String orderTime);
	
	
	
}
