package service;

import java.util.List;

import domain.UsedGoods;

public interface UsedGoodsService {
	public List<UsedGoods> getUsedGoodsList();
	
	public List<UsedGoods> getMemberUsedGoodsList(int u_id);
	
	public UsedGoods getUsedGoods(UsedGoods goods);
	
	public void insertUsedGoods(UsedGoods goods);
	
	public void updateUsedGoods(UsedGoods goods);
	
	public void deleteUsedGoods(UsedGoods goods);
}
