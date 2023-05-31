package com.spring.mugpet.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.service.ItemService;

@Controller
public class MainController {
//로그인 후, 회원의 이름 or 펫의 이름 띄울거면 수정!!!!!!
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	//main화면
	@RequestMapping("/main")
	public ModelAndView viewMain(@RequestParam(value="spe_id", defaultValue="1") int spe_id) {
		ModelAndView mav = new ModelAndView();
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(spe_id);
		
		mav.setViewName("main");
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("itemList", itemList);
		
		return mav;
	}
	
	@RequestMapping("/main/orderItem")
	public ModelAndView orderItem(@RequestParam("spe_id") int spe_id, @RequestParam("standard") String standard, @RequestParam("order") String order) {
		ModelAndView mav = new ModelAndView();
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		System.out.println(">>>>>>>>>>>>데이터 못가져옴");
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByItem(spe_id, standard, order);
		System.out.println(">>>>>>>>>>>>>데이터 가져옴");
		
		mav.setViewName("main");
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("standard", standard);
		mav.addObject("itemList", itemList);
		
		return mav;
	}
}
