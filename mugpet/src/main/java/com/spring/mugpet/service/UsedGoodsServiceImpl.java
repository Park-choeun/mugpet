package com.spring.mugpet.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.dao.UsedGoodsDao;
import com.spring.mugpet.domain.UsedGoods;

@Service
public class UsedGoodsServiceImpl implements UsedGoodsService{

	@Autowired
	private UsedGoodsDao usedgoodsDAO;
	
	private final String CURR_IMAGE_REPO_PATH = "/Users/82102/test/";
	
	@Override
	public List<UsedGoods> getUsedGoodsList() {
		return usedgoodsDAO.getUsedGoodsList();
	}

	@Override
	public List<UsedGoods> getMemberUsedGoodsList(int u_id) {
		return usedgoodsDAO.getMemberUsedGoodsList(u_id);
	}

	@Override
	public UsedGoods getUsedGoods(int g_id) {
		return usedgoodsDAO.getUsedGoods(g_id);
	}

	@Override
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand, MultipartFile file) throws Exception {
		String imgFileName = file.getOriginalFilename();
		
		//들어왔는지 체크
		System.out.println(imgFileName);
		
		UUID uuid = UUID.randomUUID();
		
		String saveFileName = uuid + "_" + imgFileName;
		goodsCommand.setImageUrl(saveFileName);
		File saveImgfile = new File(CURR_IMAGE_REPO_PATH + saveFileName);
		
		//체크
		System.out.println(saveImgfile);
		
		file.transferTo(saveImgfile);
		usedgoodsDAO.insertUsedGoods(goodsCommand);
	}

	@Override
	public void insertUsedGoodsWithoutImgFile(NewUsedGoodsCommand goodsCommand) {
		usedgoodsDAO.insertUsedGoods(goodsCommand);
	}

	@Override
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand, MultipartFile file) throws Exception {
String imgFileName = file.getOriginalFilename();
		
		//들어왔는지 체크
		System.out.println(imgFileName);
		
		UUID uuid = UUID.randomUUID();
		
		String saveFileName = uuid + "_" + imgFileName;
		goodsCommand.setImageUrl(saveFileName);
		File saveImgfile = new File(CURR_IMAGE_REPO_PATH + saveFileName);
		
		//체크
		System.out.println(saveImgfile);
		
		file.transferTo(saveImgfile);
		usedgoodsDAO.updateUsedGoods(goodsCommand);
	}

	@Override
	public void updateUsedGoodsWithoutImgFile(NewUsedGoodsCommand goodsCommand) {
		usedgoodsDAO.updateUsedGoods(goodsCommand);
	}

	@Override
	public void deleteUsedGoods(int g_id) {
		usedgoodsDAO.deleteUsedGoods(g_id);
	}

	
	@Override
	public int getU_IdByUsedGoods(int g_id) {
		return usedgoodsDAO.getU_IdByUsedGoods(g_id);
	}
}