package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsedGoodsDAO;
import domain.UsedGoods;

@Service
public class UsedGoodsServiceImpl implements UsedGoodsService{

	@Autowired
	private UsedGoodsDAO usedgoodsDAO;
	
	@Override
	public List<UsedGoods> getUsedGoodsList() {
		return usedgoodsDAO.getUsedGoodsList();
	}

	@Override
	public List<UsedGoods> getMemberUsedGoodsList(int u_id) {
		return usedgoodsDAO.getMemberUsedGoodsList(u_id);
	}

	@Override
	public UsedGoods getUsedGoods(UsedGoods goods) {
		return usedgoodsDAO.getUsedGoods(goods);
	}

	@Override
	public void insertUsedGoods(UsedGoods goods) {
		usedgoodsDAO.insertUsedGoods(goods);
	}

	@Override
	public void updateUsedGoods(UsedGoods goods) {
		usedgoodsDAO.updateUsedGoods(goods);
	}

	@Override
	public void deleteUsedGoods(UsedGoods goods) {
		usedgoodsDAO.deleteUsedGoods(goods);
	}
}