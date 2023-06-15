package com.spring.mugpet.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.service.ReplyServiceImpl;

@Controller
@SessionAttributes("userSession")
public class ReplyController {
	@Autowired
	private ReplyServiceImpl replyService;
	
	@RequestMapping(value = "/community/replyInsert")
	public String comSubmit(NewReplyCommand replyCommand, @ModelAttribute("userSession") MemberInfo userSession) {
		replyCommand.setU_id(userSession.getU_id());
		replyService.insertComReply(replyCommand);
		
		return "redirect:/community/view?com_id=" + replyCommand.getCom_id();
	}
	
	@RequestMapping(value = "/usedGoods/replyInsert")
	public String goodsSubmit(NewReplyCommand replyCommand, @ModelAttribute("userSession") MemberInfo userSession) {
		replyCommand.setU_id(userSession.getU_id());
		replyService.insertGoodsReply(replyCommand);
		
		return "redirect:/usedGoods/view?g_id=" + replyCommand.getG_id();
	}
	
	@RequestMapping("/community/replyDelete")
	public String deleteComReply(@RequestParam(value = "rp_id") int rp_id, @RequestParam(value = "com_id") int com_id) {
		//댓글 삭제
		replyService.deleteComReply(rp_id, com_id);
		
		return "redirect:/community/view?com_id=" + com_id;
	}
	
	@RequestMapping("/usedGoods/replyDelete")
	public String deleteGoodsReply(@RequestParam(value = "rp_id") int rp_id, @RequestParam(value = "g_id") int g_id) {
		//댓글 삭제
		replyService.deleteGoodsReply(rp_id, g_id);
		
		return "redirect:/usedGoods/view?g_id=" + g_id;
	}
	
	//u_id로 받나? userSession?
	@RequestMapping("/myPage/replyList")
	public String getMyReplyList(@ModelAttribute("userSession") MemberInfo userSession, Model model){
		int u_id = userSession.getU_id();
		replyService.getMyReplyList(u_id);
		
		return "/myPage/replyList";
	}
}