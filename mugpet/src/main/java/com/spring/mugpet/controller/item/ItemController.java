package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.PetService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	private PetService petService;
	public void setPetService(PetService petService) {
		this.petService = petService;
	}
	
	//종 및 카테고리에 맞는 아이템 리스트 출력
	@RequestMapping("/itemList")
	public ModelAndView viewItemListByCategory(@ModelAttribute("userSession") MemberInfo userSession,
										@RequestParam("spe_id") int spe_id, 
										@RequestParam("category_id") int category_id) {
		
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			petName = pet.getName();
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getItemList(spe_id, category_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tiles/item/itemList");
		
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("standard", "기본순");
		mav.addObject("category_id", category_id);
		mav.addObject("petName", petName);
		mav.addObject("userSession", userSession);
		
		return mav;
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public ModelAndView viewItme(@ModelAttribute("userSession") MemberInfo userSession, 
									@RequestParam("item_id") int item_id) {
		
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			petName = pet.getName();
		}
		Item item = itemService.getItem(item_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tiles/item/itemDetail");
		
		mav.addObject("item", item);
		mav.addObject("spe", petService.getSpeName(item.getSpe_id()));
		mav.addObject("petName", petName);
		
		return mav;
	}
	
	//아이템 정렬
	@RequestMapping("/orderItem")
	public ModelAndView orderItem(@ModelAttribute("userSession") MemberInfo userSession, @RequestParam("spe_id") int spe_id, 
									@RequestParam("category_id") int category_id, @RequestParam("stand") String stand, 
									@RequestParam("od") String od) {
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByItem(spe_id, category_id, stand, od);
		
		ModelAndView mav = viewItemListByCategory(userSession, spe_id, category_id);
		mav.addObject("itemList", itemList);
		mav.addObject("standard", itemService.getOrderByName(stand, od));
		
		return mav;
	}
}
