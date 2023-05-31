package com.spring.mugpet.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.service.PetService;

@Controller
@RequestMapping("/pet")
public class PetController {


	@Autowired
	private PetService petService;
	
	@ModelAttribute("petRegisterForm")
	public PetRegisterForm formBacking() {
		return new PetRegisterForm();
	}

	@RequestMapping(value="/petRegister", method=RequestMethod.GET)
	public String register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberInfo newAccount = (MemberInfo) session.getAttribute("newAccount");
		System.out.println(newAccount);
		return "member/petRegisterForm";
	}
	
	@RequestMapping(value="/petRegister", method = RequestMethod.POST)
	public String registerPet(@ModelAttribute("petRegisterForm")PetRegisterForm petRegisterForm,
							HttpServletRequest request) throws Exception {
		
	
		HttpSession session = request.getSession();
		MemberInfo newAccount = (MemberInfo) session.getAttribute("newAccount");
		System.out.println(newAccount);
		System.out.println(petRegisterForm.getPet().getName());
		petRegisterForm.getPet().setU_id(newAccount.getU_id());
		petRegisterForm.getPet().setSpe_id(Integer.parseInt(request.getParameter("species")));
		petService.addPet(petRegisterForm.getPet());
		
		return "redirect: /member/login";

	}
	
	
	
}
