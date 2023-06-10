package com.spring.mugpet.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes("userSession")
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
						@RequestParam("email") String email,
						@RequestParam("pwd") String pwd,
						@RequestParam(value="forwardAction", required=false) String forwardAction,
						Model model) throws Exception {
		MemberInfo userSession = memberService.getMemberInfoByEmailandPwd(email,pwd);
		model.addAttribute("userSession", userSession);
		if(userSession==null) {
			return new ModelAndView("error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			
			if(forwardAction != null) {
				return new ModelAndView("redirect:" + forwardAction);
			}
			else {
				return new ModelAndView("redirect:/main");
			}
		}
	}
	
	
	
}
