package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.dao.UsedGoodsDao;
import com.spring.mugpet.domain.UsedGoods;

@Service
public class UsedGoodsServiceImpl implements UsedGoodsService{

	@Autowired
	private UsedGoodsDao usedgoodsDAO;
	
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
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand) {
		usedgoodsDAO.insertUsedGoods(goodsCommand);
	}

	@Override
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand) {
		usedgoodsDAO.updateUsedGoods(goodsCommand);
	}

	@Override
	public void deleteUsedGoods(int g_id) {
		usedgoodsDAO.deleteUsedGoods(g_id);
	}
}