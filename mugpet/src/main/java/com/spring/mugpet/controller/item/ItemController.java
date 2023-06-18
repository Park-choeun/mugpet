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
import com.spring.mugpet.service.WishService;

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
	
	@Autowired
	private WishService wishService;
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
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
		mav.addObject("filterTmp", "1");
		mav.addObject("standard", "기본순");
		mav.addObject("category_id", category_id);
		mav.addObject("petName", petName);
		mav.addObject("userSession", userSession);
		
		return mav;
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public ModelAndView viewItem(@ModelAttribute("userSession") MemberInfo userSession, 
									@RequestParam("item_id") int item_id) {
		
		//비로그인 상태이면 wish=0
		int isWish = 0; 
		if(userSession.getU_id() != 0) {
			//wish에 해당 아이템이 있으면 1 반환, 없으면 0 반환
			isWish = wishService.isWish(userSession.getU_id(), item_id);
		}
		Item item = itemService.getItem(item_id);
		
		ModelAndView mav = viewItemListByCategory(userSession, item.getSpe_id(), item.getCategory_id());
		mav.setViewName("tiles/item/itemDetail");
		
		mav.addObject("item", item);
		mav.addObject("isWish", isWish);
		mav.addObject("filterTmp", null);
		
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
		//잉
		return mav;
	}
	
	
	//itemDetail에서 장바구니 or 구매하기 클릭 시 개수 선택 창
	@RequestMapping("/choiceQty")
	public ModelAndView choiceItemQty(@ModelAttribute("userSession") MemberInfo userSession,
										@RequestParam("item_id") int item_id) {
		
		ModelAndView mav = viewItme(userSession, item_id);
		mav.setViewName("/item/choiceQty");
		
		return mav;
	}
}
