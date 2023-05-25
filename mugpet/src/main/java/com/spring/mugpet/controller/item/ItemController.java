package com.spring.mugpet.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.service.ItemService;

//@Controller
//@RequestMapping("/item")
public class ItemController {
	
//	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	//main화면
	//로그인한 user의 spe_id또는 default spe_id받아서 출력
	//회원의 이름 or 펫의 이름 띄울거면 수정!!!!!!
//	@RequestMapping("/main")
	public String viewMainItemList(@RequestParam("spe_id") int spe_id, Model model) {
		List<Item> itemList = itemService.getALLItemList(spe_id);
		model.addAttribute("itemList", itemList);
		
		return "main";
	}
	
	//종 및 카테고리에 맞는 아이템 리스트 출력
	@RequestMapping("/itemList")
	//나중에 세션이름으로 바꾸기!!!!!!!
	public String viewCategoryItemList(@RequestParam("spe_id") int spe_id, @RequestParam("category_id") int category_id, Model model) {
		List<Item> itemList = itemService.getItemList(spe_id, category_id);
		model.addAttribute("itemList", itemList);
		
		return "item/itemList";
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public String viewItem(@RequestParam("item_id") int item_id, Model model) {
		Item item = itemService.getItem(item_id);
		model.addAttribute("item", item);
		
		return "item/itemDetail";
	}
	
	//아이템 정렬
	//메인에서 정렬과 카테고리 아이템리스트에서 정렬 구분을 어떻게 해야할지...?
	@RequestMapping("/orderItem")
	public String viewItem(@RequestParam("standard") String standard, @RequestParam("order") String order, Model model) {
		List<Item> orderItemList = itemService.orderByItem(standard, order);
		model.addAttribute("orderItemList", orderItemList);
		
		return "item/itemList";
	}
}
