package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.mugpet.domain.OrderItem;

@Mapper
public interface OrderItemMapper {

	//member의 주문 아이디에 해당하는 아이템 목록 가져오기
	OrderItem getOrderItemList(int o_id); 

	//member의 모든 주문 아이템 목록 가져오기
	List<OrderItem> getAllOrderItemList(int u_id);
	
	//주문 목록에 상품 추가하기	
	void insertOrderItem(OrderItem orderItem);
	
	//주문 목록에 상품 수정하기
	void updateOrderItem(OrderItem orderItem);
	
	//주문 목록에 상품 삭제하기
	void deleteOrderItem(OrderItem orderItem);
	

}
