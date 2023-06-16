package com.spring.mugpet.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.service.ItemService;

@Controller
@SessionAttributes("userSession")
public class WishController {
	
	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	private ItemController itemController;
	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	
	@RequestMapping("/item/updateWish")
	public ModelAndView updateWish(@ModelAttribute("userSession") MemberInfo userSession, 
									@RequestParam("wish") int wish, @RequestParam("item_id") int item_id) {
		ModelAndView mav = itemController.viewItme(userSession, item_id);
		System.out.println(">>>>>>>>>>wish=" + wish + ", item_id=" + item_id);
		if (wish == 0) {
			itemService.updateWish(1, item_id);
		} else {
			itemService.updateWish(0, item_id);
		}
		Item item = itemService.getItem(item_id);
		mav.addObject("item", item);
		return mav;
	}
}