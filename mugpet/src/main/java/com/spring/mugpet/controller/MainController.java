package com.spring.mugpet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;

@Controller
@RequestMapping("/main")
@SessionAttributes("member")
public class MainController {
//로그인 후, 회원의 이름 or 펫의 이름 띄울거면 수정!!!!!!
//spe_id requestParam으로 입력받았을 땐 어디에서 처리..?	
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@ModelAttribute("member")
	public MemberInfo formBacking(HttpServletRequest request) {
		Pet pet = new Pet();
		pet.setSpe_id(1); //비로그인시 spe_id는 강아지(1)로 지정
		MemberInfo mi = new MemberInfo();
		mi.setPet(pet);
		return mi;
	}
	
	//main화면
	@GetMapping
	public String form() {
		return "main";
	}
	
	//로그인 후 -> submit이 아닌데 이렇게 폼배킹 써도 되는지...?
//	@PostMapping
//	public 
}
