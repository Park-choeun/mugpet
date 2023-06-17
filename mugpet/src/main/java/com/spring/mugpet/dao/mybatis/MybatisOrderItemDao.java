package com.spring.mugpet.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.OrderItemDao;
import com.spring.mugpet.dao.mybatis.mapper.OrderItemMapper;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;

@Repository
public class MybatisOrderItemDao implements OrderItemDao {

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	//member의 주문 아이템 목록 가져오기
	public List<OrderItem> getOrderItemList(int u_id, String orderTime) throws DataAccessException{
		return orderItemMapper.getOrderItemList(u_id, orderTime);
	}

	//member의 모든 주문 아이템 목록 가져오기
	public List<String> getAllOrderTimeList(int u_id) throws DataAccessException{
		return orderItemMapper.getAllOrderTimeList(u_id);
	}
	
	//주문 목록에 있는 하나의 아이템 정보 가져오기 (상품명, 가격 등)
	public Item getOrderItemInfo(int item_id) throws DataAccessException{
		return orderItemMapper.getOrderItemInfo(item_id);
	}
	
	public List<OrderItemInfos> getAllOrderItemList(int u_id, String orderTime) throws DataAccessException{
		return orderItemMapper.getAllOrderItemList(u_id, orderTime);
	}
	//주문 목록에 상품 추가하기	
	public void insertOrderItem(OrderItem orderItem) throws DataAccessException{
		orderItemMapper.insertOrderItem(orderItem);
	}
	
//	//주문 목록에 상품 수정하기
//	public void updateOrderItem(OrderItem orderItem) throws DataAccessException{
//		orderItemMapper.updateOrderItem(orderItem);
//	}
//		
	//주문 목록 삭제하기
	public void deleteOrderItem(int u_id, String orderTime) throws DataAccessException{
		orderItemMapper.deleteOrderItem(u_id, orderTime);
	}

	@Override
	public int getOrderItemCnt(int u_id) throws DataAccessException {
		return orderItemMapper.getOrderItemCnt(u_id);
	}

	@Override
	public OrderItem isCheckOrderItem(int u_id, int item_id) throws DataAccessException {
		return orderItemMapper.isCheckOrderItem(u_id,item_id);
		
	}
	
	
}
