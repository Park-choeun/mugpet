package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.OrderItemDao;
import com.spring.mugpet.dao.mybatis.mapper.OrderItemMapper;
import com.spring.mugpet.domain.OrderItem;

@Repository
public class MybatisOrderItemDao implements OrderItemDao {

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	//member의 주문 아이템 목록 가져오기
	public List<OrderItem> getOrderItemList(int o_id) throws DataAccessException{
		return orderItemMapper.getOrderItemList(o_id);
	}

	//member의 모든 주문 아이템 목록 가져오기
	public List<OrderItem> getAllOrderItemList(int u_id) throws DataAccessException{
		return orderItemMapper.getAllOrderItemList(u_id);
	}
	
	//주문 목록에 상품 추가하기	
	public void insertOrderItem(OrderItem orderItem) throws DataAccessException{
		orderItemMapper.insertOrderItem(orderItem);
	}
	
	//주문 목록에 상품 수정하기
	public void updateOrderItem(OrderItem orderItem) throws DataAccessException{
		orderItemMapper.updateOrderItem(orderItem);
	}
		
	//주문 목록에 상품 삭제하기
	public void deleteOrderItem(OrderItem orderItem) throws DataAccessException{
		orderItemMapper.deleteOrderItem(orderItem);
	}
	
	
}
