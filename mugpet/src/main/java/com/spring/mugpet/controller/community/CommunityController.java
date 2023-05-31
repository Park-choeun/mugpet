package com.spring.mugpet.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.domain.Community;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.service.CommunityServiceImpl;
import com.spring.mugpet.service.ReplyServiceImpl;

@Controller
@RequestMapping(method=RequestMethod.GET)
@SessionAttributes("u_id")
/*form 사용시, Command 객체 사용*/
public class CommunityController {
	/*진행 상황에 따라 코드 수정 必*/
	@Autowired
	private CommunityServiceImpl comService;
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	@RequestMapping("/community/view")
	public String getCom(Model model, @RequestParam(value = "com_id") int com_id) {
		//게시글 상세보기
		Community com = null;
		com = comService.getCom(com_id);
		
		List<Reply> replyList = replyService.getCommunityReplyList(com_id);
		
		model.addAttribute("community", com);
		model.addAttribute("replyList", replyList);
		
		return "/community/view";
	}
	
	@RequestMapping("/community/communityList")
	public String getComList(Model model) {
		//게시글 목록 보기
		List<Community> comList = comService.getComList();
		
		model.addAttribute("comList", comList);
		
		return "/community/communityList";
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
	public String form() {

		return "/community/writeForm";
	}
	
	//폼에서 작성 완료 버튼을 누르면 해당 글과 관련된 내용을 db에 저장 후 목록or상세보기 페이지로 이동
	@RequestMapping(value = "/community/write", method = RequestMethod.POST)
	public String submit(NewCommunityCommand comCommand) {
		comService.insertCom(comCommand);
		
		return "redirect:/community/view";		
	}
}