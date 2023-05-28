package com.spring.mugpet.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.service.ItemService;

@Controller
//@SessionAttributes("u_id")
public class MainController {
//로그인 후, 회원의 이름 or 펫의 이름 띄울거면 수정!!!!!!
//spe_id requestParam으로 입력받았을 땐 어디에서 처리..?	
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	//main화면
	//@ModelAttribute("u_id") int u_id
	//petService.getSpe_id로 불러오기
	//제발...
	@RequestMapping("/main")
	public ModelAndView viewMain(String spe_id) {
		ModelAndView mav = new ModelAndView();
		String spe;
		if (spe_id.equals("1")) {
			spe = "강아지";
		} else if (spe_id.equals("2")) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		System.out.println(">>>>>>>>>>>>" + spe);
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(1);
		
		System.out.println(">>>>>>>>>>>>" + itemList.get(0).getItemName());
		
		mav.addObject("spe", spe);
		mav.addObject("itemList", itemList);
		
		return mav;
	}
}
