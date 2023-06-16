package com.spring.mugpet.controller.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.controller.item.ItemController;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.service.ItemService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/myPage")
public class MyPageController {

	@Autowired
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping(value="/myOrderList" , method=RequestMethod.GET)
	public String myOrderList() throws Exception {
			
		return "/mypage/myOrderList";
	
	}
	
	
	
	@RequestMapping(value="/myHome",method=RequestMethod.GET)
	public String myHome(@ModelAttribute("userSession")MemberInfo userSession,Model model) throws Exception {
		
		
		

		
		
		return "tile/myPage/myHome";
	}
	
//	@RequestMapping(value="/myOrderList" , method=RequestMethod.POST)
//	public String myOrderList(HttpServletRequest request) throws Exception {
//		
//		HttpSession session = request.getSession();
//		UserSession userSession = (UserSession) session.getAttribute("userSession");
//		
//		
//		if(userSession != null) {
//			
//		
//		}
//		
//		
//		
//	}
	
	
	
}
