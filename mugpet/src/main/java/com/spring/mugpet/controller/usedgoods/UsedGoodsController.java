package com.spring.mugpet.controller.usedgoods;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mugpet.domain.UsedGoods;
import com.spring.mugpet.service.UsedGoodsServiceImpl;

@Controller
@RequestMapping("/usedgoods")
public class UsedGoodsController {
	private UsedGoodsServiceImpl goodsService;
	
	@RequestMapping("/usedGoods/view")
	public String viewUsedGoods(Model model, @RequestParam(value = "g_id") int g_id) {
		//게시글 상세보기
		UsedGoods goods = null;
		goods = goodsService.getUsedGoods(g_id);
		
		model.addAttribute("usedGoods", goods);
		
		return "/usedGoods/view";
	}
	
	@RequestMapping("/usedGoods/usedGoodsList")
	public String goodsList(Model model) {
		//게시글 목록보기
		List<UsedGoods> goodsList = goodsService.getUsedGoodsList();
		
		model.addAttribute("UsedGoodsList", goodsList);
		
		return "/usedGoods/usedGoodsList";
	}
	
	@RequestMapping("/usedGoods/delete")
	public String deleteGoods(@RequestParam(value = "g_id") int g_id) {
		goodsService.deleteUsedGoods(g_id);
		
		return "redirect:/usedGoods/usedGoodsList";
	}
	
	@RequestMapping(value = "/usedGoods/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("g_id") int g_id) {
		UsedGoods goods = null;
		goods = goodsService.getUsedGoods(g_id);
		
		model.addAttribute("usedGoods", goods);
		
		return "/usedGoods/updateForm";
	}
	
	@RequestMapping(value = "/usedGoods/update", method = RequestMethod.POST)
	public String updateSubmit(NewUsedGoodsCommand goodsCommand) {
		goodsService.updateUsedGoods(goodsCommand);
		
		return "redirect:/usedGoods/view";
	}
	
	@RequestMapping(value = "/usedGoods/insertForm", method = RequestMethod.GET)
	public String form() {
		return "/usedGoods/insertForm";
	}
	
	@RequestMapping(value = "/usedGoods/insert", method = RequestMethod.POST)
	public String submit(NewUsedGoodsCommand goodsCommand) {
		goodsService.insertUsedGoods(goodsCommand);
		
		return "redirect:/usedGoods/view";
	}
}
