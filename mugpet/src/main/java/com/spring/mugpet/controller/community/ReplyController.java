package com.spring.mugpet.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.service.ReplyServiceImpl;

@Controller
public class ReplyController {
	@Autowired
	private ReplyServiceImpl replyService;
	
	/*
	 * //댓글 작성
	 * 
	 * @RequestMapping("/reply/insert") public String form() { return "~~~~"; }
	 */
	
	//댓글 등록 -> SpringMvcExample의 search controller처럼 변경해야할 듯함
	@RequestMapping(value = "/community/reply/insert")
	public String comSubmit(NewReplyCommand replyCommand) {
		replyService.insertComReply(replyCommand);
		
		return "redirect:/community/view";
	}
	
	@RequestMapping(value = "/usedGoods/reply/insert")
	public String goodsSubmit(NewReplyCommand replyCommand) {
		replyService.insertGoodsReply(replyCommand);
		
		return "redirect:/usedGoods/view";
	}
	
	/*
	 * @RequestMapping("/community/view") public String getCommunityReplyList(Model
	 * model, @RequestParam(value = "com_id") int com_id){ //댓글 목록 보기 List<Reply>
	 * replyList = replyService.getCommunityReplyList(com_id);
	 * 
	 * model.addAttribute("ReplyList", replyList);
	 * 
	 * return "/community/view"; }
	 */
	
	@RequestMapping("/usedGoods/view")
	public String getUsedGoodsReplyList(Model model, @RequestParam(value = "g_id") int g_id){
		//댓글 목록 보기
		List<Reply> replyList = replyService.getUsedGoodsReplyList(g_id);
		
		model.addAttribute("ReplyList", replyList);
		
		return "/usedGoods/view";
	}
	
	@RequestMapping("/community/reply/delete")
	public String deleteComReply(@RequestParam(value = "rp_id") int rp_id, @RequestParam(value = "com_id") int com_id) {
		//댓글 삭제
		replyService.deleteComReply(rp_id, com_id);
		
		return "redirect:/community/view";
	}
	
	@RequestMapping("/usedGoods/reply/delete")
	public String deleteGoodsReply(@RequestParam(value = "rp_id") int rp_id, @RequestParam(value = "g_id") int g_id) {
		//댓글 삭제
		replyService.deleteGoodsReply(rp_id, g_id);
		
		return "redirect:/usedGoods/view";
	}
}