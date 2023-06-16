package com.spring.mugpet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.PetService;

@Controller
@SessionAttributes("userSession")
public class MainController {
	
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

	@ModelAttribute("userSession")
	public MemberInfo userSession(HttpServletRequest request) {
		MemberInfo userSession = (MemberInfo) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession == null) {
			return new MemberInfo();
		}
		return userSession;
	}

	//main view
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView viewMain(@ModelAttribute("userSession") MemberInfo userSession,
								@RequestParam(value="spe_id", defaultValue="1") int spe_id) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tiles/main");
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(spe_id);	
		
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("tmp", 0);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("standard", "기본순");
		mav.addObject("petName", petName);
		mav.addObject("userSession", userSession);
		
		return mav;
	}
	
	
	//종 선택 시 아이템 변경(session의 spe_id와는 무관하게)
	@RequestMapping(value="/main/speId", method=RequestMethod.GET)
	public ModelAndView viewSpeMain(@ModelAttribute("userSession") MemberInfo userSession,
								@RequestParam("spe_id") int spe_id) {
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(spe_id);	
		
		ModelAndView mav = viewMain(userSession, spe_id);
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		
		return mav;
	}
  
	
	//main에서 아이템 정렬
	@RequestMapping("/main/orderItem")
	public ModelAndView orderByItem(@ModelAttribute("userSession") MemberInfo userSession, 
								@RequestParam("spe_id") int spe_id,
								@RequestParam("stand") String stand, 
								@RequestParam("od") String od) {
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.orderByItem(spe_id, 0, stand, od);
		
		ModelAndView mav = viewMain(userSession, spe_id);
		mav.addObject("itemList", itemList);
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", petService.getSpeName(spe_id));
		mav.addObject("standard", itemService.getOrderByName(stand, od));
		
		return mav;
	}
}