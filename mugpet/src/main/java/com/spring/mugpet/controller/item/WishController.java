package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.Wish;
import com.spring.mugpet.service.WishService;

@Controller
@RequestMapping("/wish")
public class WishController {
	
	@Autowired
	private WishService wishService;
	
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}
	
	//Wish에 해당하는 아이템 조회
	@RequestMapping(value="/myWishList", method=RequestMethod.GET)
	public ModelAndView getWishList() {
		List<Wish> wishItems = wishService.getWishList(1);
		List<Item> wishItemsInfo = new ArrayList<Item>();
		int wishItemQty = wishItems.size();

		for(Wish items : wishItems) {
			int item_id = items.getItem_id();
			Item info = wishService.getWishItemInfo(item_id);
			System.out.println("위시 첫번째 아이템 이름: " + info.getItemName());
			wishItemsInfo.add(info);
		}
		ModelAndView mav = new ModelAndView("/wish/myWishList");
		
		System.out.println("위시 아이템 개수" + wishItemQty);
		mav.addObject("wishItemsInfo", wishItemsInfo);
		
		return mav;
	}
//	public String getWishList(Wish wish, Model model) {
//		List<Wish> wishItems = wishService.getWishList(wish.getU_id());
//		model.addAttribute("wishItems", wishItems);
//		return "/myWishList.jsp";
//	}
	
	//Wish에 해당하는 아이템 하나 클릭 시 그 아이템 상세페이지로 이동하는 url을 반환하는 메소드
	@RequestMapping("/myWishList/{item_id}")
	public String wishItemDetail(int item_id) {
		return "item/itemDetail";
	}
}
