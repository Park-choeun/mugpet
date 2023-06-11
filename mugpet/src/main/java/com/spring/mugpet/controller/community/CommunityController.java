package com.spring.mugpet.controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.domain.Community;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.service.CommunityServiceImpl;
import com.spring.mugpet.service.MemberServiceImpl;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.ReplyServiceImpl;

@Controller
@SessionAttributes("userSession")
@RequestMapping(method=RequestMethod.GET)
//@SessionAttributes("userSession")
/*form 사용시, Command 객체 사용*/
public class CommunityController {
	
	@Autowired
	private CommunityServiceImpl comService;
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private PetService petService;
	
	@RequestMapping("/community/view")
	public String getCom(Model model, @RequestParam(value = "com_id") int com_id) {
		//게시글 상세보기
		Community com = null;
		com = comService.getCom(com_id);
		
		List<Reply> replyList = replyService.getCommunityReplyList(com_id);
		
		int u_id = comService.getU_IdByCommunity(com_id);
		//int u_id = com.getU_id();
		String nickname = memberService.getNickNameByU_Id(u_id);
		
		model.addAttribute("community", com);
		model.addAttribute("replyList", replyList);
		model.addAttribute("nickname", nickname);
		
		return "/community/view";
	}
	
	@RequestMapping("/community/communityList")
	public String getComList(Model model,@ModelAttribute("userSession")MemberInfo userSession) {
		//게시글 목록 보기
		
		int spe_id = 1;
		String petName = null;
		List<Community> comList = comService.getComList();
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		
		}
		//ArrayList<String> nicknameList = new ArrayList<String>();
		/*
		for(Community coms : comList) {
			int u_id = coms.getU_id();
			//int u_id = comService.getU_IdByCommunity(com_id);
			String nickname = memberService.getNickNameByU_Id(u_id);
			nicknameList.add(nickname);
		}*/
	
		String spe;
		if (spe_id == 1) {
			spe = "강아지";
		} else if (spe_id == 2) {
			spe = "고양이";
		} else {
			spe = "소동물";
		}
				
		for(Community com : comList) {
			System.out.println(com.getTitle());
			System.out.println(com.getCom_id());
		}
		model.addAttribute("comList", comList);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", spe);
		//model.addAttribute("nicknameList", nicknameList);
		
		return "tiles/community/communityList";
	}
	
	@RequestMapping("/community/myCommunityList")
	public String getMemberComList(Model model, @ModelAttribute("u_id") int u_id) {
		//본인이 쓴 게시글 목록 보기
		List<Community> myComList = comService.getMemberComList(u_id);
		
		model.addAttribute("myComList", myComList);
		
		return "/community/myCommunityList";
	}
	
	@RequestMapping("/community/delete")
	public String deleteCom(@RequestParam(value = "com_id") int com_id) {
		//게시글 삭제
		comService.deleteCom(com_id);
		
		return "redirect:/community/communityList";
	}
	
	//글 수정 버튼 클릭시, 수정 폼으로 이동
	@RequestMapping(value = "/community/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("com_id") int com_id) {
		Community com = null;
		com = comService.getCom(com_id);
		
		model.addAttribute("community", com);
		
		return "/community/updateForm";
	}
	
	//수정 폼에서 수정 완료 버튼 클릭시, 해당 글과 관련된 내용을 db에 수정해 저장 후 목록or상세보기 페이지로 이동
	@RequestMapping(value = "community/update", method = RequestMethod.POST)
	public String updateSubmit(NewCommunityCommand comCommand) {
		comService.updateCom(comCommand);
		
		return "redirect:/community/view";
	}
	
	//글 작성 버튼 누르면 폼으로 이동
	@RequestMapping(value = "/community/writeForm", method = RequestMethod.GET)
	public String form(@ModelAttribute NewCommunityCommand comCommand) {

		return "/community/writeForm";
	}
	
	//폼에서 작성 완료 버튼을 누르면 해당 글과 관련된 내용을 db에 저장 후 목록or상세보기 페이지로 이동
	@RequestMapping(value = "/community/write", method = RequestMethod.POST)
	public String submit(@ModelAttribute NewCommunityCommand comCommand, BindingResult result, HttpServletRequest request,
						@RequestPart(value="imgFile", required=false) MultipartFile file) throws Exception {
		
		//UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//int u_id = userSession.getMemberInfo().getU_id();
		//System.out.println(u_id);
		
		comCommand.setU_id(2);
		comCommand.setCom_id(1);
		
		comService.insertCom(comCommand, file);
	
		return "redirect:/community/view";		
	}
	
	/*@ModelAttribute("u_id")
	public int user(HttpServletRequest request) throws Exception{
		System.out.println(request.getSession().getAttribute("u_id"));
		return (int)request.getSession().getAttribute("u_id");
	}*/
}