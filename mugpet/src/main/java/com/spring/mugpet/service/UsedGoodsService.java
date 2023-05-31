package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.domain.UsedGoods;

public interface UsedGoodsService {
	public List<UsedGoods> getUsedGoodsList();
	
	public List<UsedGoods> getMemberUsedGoodsList(int u_id);
	
	public UsedGoods getUsedGoods(int g_id);
	
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand);
	
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand);
	
	public void deleteUsedGoods(int g_id);
}
