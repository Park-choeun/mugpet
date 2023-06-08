package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	//종 및 카테고리에 맞는 아이템 리스트 출력
	@RequestMapping("/itemList")
	public ModelAndView viewItemListByCategory(@RequestParam("spe_id") int spe_id, @RequestParam("category_id") int category_id) {
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
		itemList = itemService.getItemList(spe_id, category_id);
		
		mav.setViewName("/item/itemList");
		mav.addObject("category_id", category_id);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("itemList", itemList);
		mav.addObject("standard", "기본순");
		
		return mav;
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public ModelAndView viewItme(@RequestParam("item_id") int item_id) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(">>>>>>>>>>>" + item_id);
		Item item = itemService.getItem(item_id);
		System.out.println(">>>>>>>>>>>" + item);
		int spe_id=item.getSpe_id();
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		
		mav.addObject("spe", spe);
		mav.setViewName("/item/itemDetail");
		mav.addObject("item", item);
		
		return mav;
	}
	
	//아이템 정렬
	@RequestMapping("/orderItem")
	public ModelAndView orderItem(@RequestParam("spe_id") int spe_id, 
			@RequestParam("category_id") int category_id, @RequestParam("stand") String stand, @RequestParam("od") String od) {
		ModelAndView mav = new ModelAndView();
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
	
		String standard;
		if (stand.equals("itemName")) {
			standard = "이름순";
		} else {
			if (od.equals("ASC")) {
				standard = "가격낮은순";
			} else {
				standard = "가격높은순";
			}
		}
	
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByCategoryItem(spe_id, spe_id, stand, od);
		System.out.println(">>>>>" + itemList.size());
				
		mav.setViewName("/item/itemList");
		mav.addObject("category_id", category_id);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("standard", standard);
		mav.addObject("itemList", itemList);
	
		return mav;
	}
	
	
	//필터창 띄우기
	@RequestMapping("/filter")
	public String viewFilter() {
		return "/item/filter";
	}
	
	//필터링 한 결과 출력
	@RequestMapping("/filterItem")
	public ModelAndView filterItem(@RequestParam("spe_id") int spe_id, @RequestParam("age") int age, 
			@RequestParam("stuff") String stuff, @RequestParam("feature") String feature) {
		ModelAndView mav = new ModelAndView();
		List<Item> itemList = new ArrayList<Item>();
		
		
		
		return mav;
	}
	
}
