package com.spring.mugpet.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

	
	@RequestMapping(value="/myOrderList" , method=RequestMethod.GET)
	public String myOrderList() throws Exception {
			
		return "/mypage/myOrderList";
	
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
