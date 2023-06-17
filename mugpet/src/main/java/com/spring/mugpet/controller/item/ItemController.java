package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@Autowired
	private PetService petService;
	
	//종 및 카테고리에 맞는 아이템 리스트 출력
	@RequestMapping("/itemList")
	public String viewItemListByCategory(@ModelAttribute("userSession") MemberInfo userSession,
										@RequestParam("spe_id") int spe_id, 
										@RequestParam("category_id") int category_id,
										ModelMap model) {
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
		itemList = itemService.getItemList(spe_id, category_id);
		
		model.put("itemList", itemList);
		model.put("spe_id", spe_id);
		model.put("spe", spe);
		model.put("standard", "기본순");
		model.put("category_id", category_id);
		model.put("petName", petName);
		model.put("userSession",userSession);
		
		return "tiles/item/itemList";
	}
	
	//아이템 상세 정보 출력
	@RequestMapping("/itemDetail")
	public String viewItme(@ModelAttribute("userSession") MemberInfo userSession, 
							@RequestParam("item_id") int item_id, ModelMap model) {
		
		String petName = null;
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			petName = pet.getName();
		}
		
		Item item = itemService.getItem(item_id);
		int spe_id = item.getSpe_id();
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
		
		model.put("spe", spe);
		model.put("petName", petName);
		model.put("item", item);
		
		return "tiles/item/itemDetail";
	}
	
	//아이템 정렬
	@RequestMapping("/orderItem")
	public String orderItem(@ModelAttribute("userSession") MemberInfo userSession, @RequestParam("spe_id") int spe_id, 
							@RequestParam("category_id") int category_id, @RequestParam("stand") String stand, 
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
		itemList = itemService.orderByCategoryItem(spe_id, spe_id, stand, od);
		
		model.put("itemList", itemList);
		model.put("spe_id", spe_id);
		model.put("spe", spe);
		model.put("standard", "기본순");
		model.put("category_id", category_id);
		model.put("petName", petName);
		model.put("userSession",userSession);
		
		return "tiles/item/itemList";
	}
	
	
	//필터창 띄우기
	@RequestMapping("/filter")
	public String viewFilter(@RequestParam("spe_id") int spe_id, ModelMap model) {
		List<String> ages = new ArrayList<String>();
		ages.add("퍼피");
		ages.add("어덜트");
		ages.add("시니어");
		ages.add("전연령");
		
		List<String> stuffs = new ArrayList<String>();
		stuffs.add("닭");
		stuffs.add("소");
		stuffs.add("오리");
		stuffs.add("연어");
		stuffs.add("기타");
		
		List<String> features = new ArrayList<String>();
		features.add("눈건강");
		features.add("치석제거");
		features.add("피부/털개선");
		features.add("뼈/관절강화");
		features.add("소화/장기능개선");
		features.add("다이어트");
		
		model.put("spe_id", spe_id);
		model.put("ages", ages);
		model.put("stuffs", stuffs);
		model.put("features", features);
		
		return "/item/filter";
	}
	
	//필터링 한 결과 출력
	@RequestMapping("/filterItem")
	public ModelAndView filterItem(@RequestParam("spe_id") int spe_id, @RequestParam("age") int age, 
			@RequestParam("stuff") String stuff, @RequestParam("feature") String feature) {
		ModelAndView mav = new ModelAndView();
		List<Item> itemList = new ArrayList<Item>();
		
		
		
		return mav;
	}
	
}
