package com.spring.mugpet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@SessionAttributes("memberInfo")
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

//	@ModelAttribute("userSession")
//	public MemberInfo userSession(HttpServletRequest request) {
//		MemberInfo userSession = (MemberInfo) WebUtils.getSessionAttribute(request, "userSession");
//		if (userSession == null) {
//			return new MemberInfo();
//		}
//		else {
//			return userSession;
//		}
//		
//	}
	
//	@RequestMapping(value="/main", method=RequestMethod.GET)
//	public String viewMain(HttpServletRequest request,
//						@RequestParam(value="spe_id", defaultValue="1") int spe_id,
//						ModelMap model) throws Exception{
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	@ModelAttribute("memberInfo")
	public String viewMain(@RequestParam(value="spe_id", defaultValue="1") int spe_id, ModelMap model) {
		
//		MemberInfo userSession = (MemberInfo) request.getSession().getAttribute("userSession");
	
		MemberInfo userSession = new MemberInfo();
		String petName = null;
		
		System.out.println("<<펫 정보 출력>>");
		System.out.println(">>>>>u_id : " + userSession.getU_id());
		if (userSession.getEmail() != null) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			System.out.println(">>>>>>>pet : " + pet);
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>petName : " + petName);
		}
		
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		System.out.println("<<<<<<<spe_id : " + spe_id);
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(spe_id);	
		
		model.put("spe_id", spe_id);
		model.put("spe", spe);
		model.put("standard", "기본순");
		model.put("petName", petName);
		model.put("itemList", itemList);
		return "main";
	}
  
	
	@RequestMapping("/main/orderItem")
	public ModelAndView orderItem(@RequestParam("spe_id") int spe_id, @RequestParam("stand") String stand, @RequestParam("od") String od) {
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
		itemList = itemService.orderByALLItem(spe_id, stand, od);
		
		mav.setViewName("main");
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("standard", standard);
		mav.addObject("itemList", itemList);
		
		return mav;
	}


}

