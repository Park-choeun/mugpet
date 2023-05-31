package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		System.out.println(">>>>>>>>>>>" + spe_id + "///////" + category_id);
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getItemList(spe_id, category_id);
		
		mav.setViewName("/item/itemList");
		mav.addObject("category_id", category_id);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("itemList", itemList);
		
		return mav;
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public ModelAndView viewItme(@RequestParam("item_id") int item_id) {
		ModelAndView mav = new ModelAndView();
		Item item = itemService.getItem(item_id);
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
//	@RequestMapping("/orderItem")
//	public ModelAndView orderItem(@RequestParam("spe_id") int spe_id, @RequestParam("standard") String standard, @RequestParam("order") String order) {
//		ModelAndView mav = new ModelAndView();
//		Item item = itemService.getItem(item_id);
//		int spe_id=item.getSpe_id();
//		String spe;
//		if (spe_id == 1) {
//			spe = "강아지";
//		} else if (spe_id == 2) {
//			spe = "고양이";
//		} else {
//			spe = "소동물";
//		}
//		
//		mav.addObject("spe", spe);
//		mav.setViewName("/item/itemDetail");
//		mav.addObject("item", item);
//		
//		return mav;
//	}
}
