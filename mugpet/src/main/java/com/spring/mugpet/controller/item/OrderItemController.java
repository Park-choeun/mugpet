package com.spring.mugpet.controller.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.OrderItem;
import com.spring.mugpet.domain.OrderItemInfos;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.OrderItemService;
import com.spring.mugpet.service.PetService;

@Controller
@SessionAttributes("userSession")
public class OrderItemController {//mypage에서 연결되는 것들은 어떻게??
	
	@Autowired 
	private OrderItemService orderItemService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PetService petService;
	
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public void setPetService(PetService petService) {
		this.petService = petService;
	}
	
	@RequestMapping(value="/myPage/myOrderList", method=RequestMethod.GET)
	public ModelAndView viewOrderList(@ModelAttribute("userSession") MemberInfo userSession, @ModelAttribute("orderItemCommand") OrderItemCommand command) {
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
		ModelAndView mav = new ModelAndView("tiles/myPage/myOrderList");
		MemberInfo memberInfo = memberService.getMemberInfoByEmailandPwd(userSession.getEmail(), userSession.getPwd());
		
		Map<String, Object> orderItemsInfoList = new LinkedHashMap<String, Object>();
		
		List<String> orderTimeList = orderItemService.getAllOrderTimeList(userSession.getU_id()); //u_id가 가진 시간을 가져와
		List<Integer> itemsSize = new ArrayList<>();
		int totalPrice = 0;
		List<Integer> orderItemsPrice = new ArrayList<Integer>();
		//그 시간에 해당되는 데이터들을 가져와서 map에 넣어
		for(String orderTime : orderTimeList) { //시간얻어옴
			List<OrderItem> itemsByTime = orderItemService.getOrderItemList(userSession.getU_id(), orderTime); //시간에 해당하는 item행 얻어옴
			int count = itemsByTime.size();
			itemsSize.add(count);
			List<OrderItemInfos> orderItemsInfo = orderItemService.getAllOrderItemList(userSession.getU_id(), orderTime);		
			for(OrderItem item : itemsByTime) { //5개가 넘어옴
				totalPrice = totalPrice + item.getItemPrice();
				
			}
			orderItemsInfoList.put(orderTime, orderItemsInfo); //map에 ordertime에 따른 item정보들을 넣음
			orderItemsPrice.add(totalPrice);
			totalPrice = 0;
		}
		
		mav.addObject("memberInfo", memberInfo);
		mav.addObject("orderItemsInfoList", orderItemsInfoList); 
		mav.addObject("itemsSize", itemsSize);			  //시간에 따라 담긴 아이템들의 총 개수
		mav.addObject("orderItemsPrice", orderItemsPrice); //시간에 따라 담긴 아이템들의 총 가격 리스트
		mav.addObject("spe_id", spe_id);
		mav.addObject("spe", spe);
		mav.addObject("petName", petName);
		
		return mav;
	}
}

