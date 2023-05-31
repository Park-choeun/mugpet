package com.spring.mugpet.controller.item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.service.OrderItemService;

@Controller
public class OrderItemController {//mypage에서 연결되는 것들은 어떻게??
	
	@Autowired 
	private OrderItemService orderItemService;
	
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	
//	public OrderItem formBacking(HttpServletRequest request) {
//		if (request.getMethod().equalsIgnoreCase("GET")) { 
//			Member
//		}
//	}
	@GetMapping()
	public String form() {
		return "/cart/myCartList";
	}
	
//	@RequestMapping(value="/cart/order", method=RequestMethod.POST)
//	public String submit(@ModelAttribute("command")OrderItemCommand command) { //매개변수 설정해야 함
//		orderItemService.getAllOrderItemList(1);
//		return "/cart/order";
//	}
}

