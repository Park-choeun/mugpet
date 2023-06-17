package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.Cart;
import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Wish;
import com.spring.mugpet.service.WishService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/wish")
public class WishController {
	
	@Autowired
	private WishService wishService;
	
	public void setWishService(WishService wishService) {
		this.wishService = wishService;
	}
	
	public void insertWish(Wish wish) throws Exception{
		wishService.insertWish(wish);
	}
	
	
	//Wish에 해당하는 아이템 조회
	@RequestMapping(value="/myWishList", method=RequestMethod.GET)
	public ModelAndView getWishList(@ModelAttribute("userSession") MemberInfo userSession) {
		List<Wish> wishItems = wishService.getWishList(userSession.getU_id());
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
	
	//각각의 물품 삭제할 수 있는 메소드 =>-버튼 클릭시 사라짐
	@RequestMapping(value="/removeItemFromWish", method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam("item_id") int item_id) throws Exception{
		wishService.deleteWish(item_id);

		return new ModelAndView("redirect:/wish/myWishList");
	}
//	//Wish에 해당하는 아이템 하나 클릭 시 그 아이템 상세페이지로 이동하는 url을 반환하는 메소드
//	@RequestMapping("/myWishList/{item_id}")
//	public String wishItemDetail(int item_id) {
//		return "item/itemDetail";
//	}
}
