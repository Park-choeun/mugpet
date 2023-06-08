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
//로그인 후, 회원의 이름 or 펫의 이름 띄울거면 수정!!!!!!
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private PetService petService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	public void setPetService(PetService petService) {
		this.petService = petService;
	}
	
	
	@ModelAttribute("memberInfo")
	public MemberInfo userSession(HttpServletRequest request) {
		MemberInfo userSession = (MemberInfo) WebUtils.getSessionAttribute(request, "userSession");
		if ( userSession == null) {
			return new MemberInfo();
		}
		else return userSession;
		
	}
	
	
	//main화면
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String viewMain(HttpServletRequest request,
						@RequestParam(value="spe_id", defaultValue="1") int spe_id,
						ModelMap model) throws Exception{
		
		MemberInfo userSession = (MemberInfo) request.getSession().getAttribute("userSession");
		if(userSession !=null) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			System.out.println(pet);
			spe_id = pet.getSpe_id();
			System.out.println(spe_id);
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
		model.put("sep_id", spe_id);
		model.put("spe", spe);
		model.put("standard", "기본순");
		return "tiles/main";

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
		itemList = itemService.orderByItem(spe_id, stand, od);
		
		mav.setViewName("main");
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("standard", standard);
		mav.addObject("itemList", itemList);
		
		return mav;
	}
}
