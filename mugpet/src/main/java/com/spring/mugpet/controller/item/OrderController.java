package com.spring.mugpet.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping()
public class OrderController {
	//@Autowired private BuyService buyservice;
	
//	@GetMapping()
	public String form() {
		return "a";
	}
	
//	@PostMapping()
	public String submit() { //매개변수 설정해야 함
		return "a";
	}
}