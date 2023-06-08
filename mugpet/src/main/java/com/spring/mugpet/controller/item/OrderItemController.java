package com.spring.mugpet.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mugpet.service.OrderItemService;

@Controller
public class OrderItemController {
	//form 보여주기
	//mypage에서 연결되는 것들도 처리(나의 주문 목록 보기)
	
	@Autowired 
	private OrderItemService orderItemService;
	
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
}

