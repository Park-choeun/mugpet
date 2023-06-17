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
import org.springframework.web.util.WebUtils;

import com.spring.mugpet.domain.Item;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.ItemService;
import com.spring.mugpet.service.MemberService;
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
	public String viewMain(@ModelAttribute("userSession") MemberInfo userSession,
							ModelMap model) throws Exception{
		
		int spe_id = 1;
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			spe_id = pet.getSpe_id();
			petName = pet.getName();
		}
		
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(spe_id);	
		
		model.put("itemList", itemList);
		model.put("spe_id", spe_id);
		model.put("spe", spe);
		model.put("standard", "기본순");
		model.put("petName", petName);
		model.put("userSession",userSession);
		
		return "tiles/main";
	}
	
	//종 선택 시 아이템 변경
	@RequestMapping(value="/main/speId", method=RequestMethod.GET)
	public String viewSpeMain(@ModelAttribute("userSession") MemberInfo userSession,
								@RequestParam("spe_id") int spe_id,
								ModelMap model) throws Exception{
		
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			petName = pet.getName();
		}
		
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemService.getALLItemList(spe_id);	
		
		model.put("itemList", itemList);
		model.put("spe_id", spe_id);
		model.put("spe", spe);
		model.put("standard", "기본순");
		model.put("petName", petName);
		model.put("userSession",userSession);
		
		return "tiles/main";
	}
  
	
	//main에서 아이템 정렬
	@RequestMapping("/main/orderItem")
	public String orderByItem(@ModelAttribute("userSession") MemberInfo userSession, 
								@RequestParam("spe_id") int spe_id,
								@RequestParam("stand") String stand, 
								@RequestParam("od") String od, ModelMap model) {
		
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			petName = pet.getName();
		}
		
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
		
		
		model.put("itemList", itemList);
		model.put("spe_id", spe_id);
		model.put("spe", spe);
		model.put("standard", standard);
		model.put("petName", petName);
		model.put("userSession",userSession);
		
		return "tiles/main";
	}


}