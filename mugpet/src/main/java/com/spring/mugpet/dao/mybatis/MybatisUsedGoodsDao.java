package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.dao.UsedGoodsDao;
import com.spring.mugpet.dao.mybatis.mapper.UsedGoodsMapper;
import com.spring.mugpet.domain.UsedGoods;

@Repository
public class MybatisUsedGoodsDao implements UsedGoodsDao{
	@Autowired
	private UsedGoodsMapper goodsMapper;
	
	@Override
	public List<UsedGoods> getUsedGoodsList() throws DataAccessException{
		//게시글 목록 보기
		return goodsMapper.getUsedGoodsList();
	}

	@Override
	public List<UsedGoods> getMemberUsedGoodsList(int u_id) throws DataAccessException{
		//본인이 쓴 게시글 목록 보기
		return goodsMapper.getMemberUsedGoodsList(u_id);
	}

	@Override
	public UsedGoods getUsedGoods(int g_id) throws DataAccessException{
		//게시글 상세보기
		return goodsMapper.getUsedGoods(g_id);
	}

	@Override
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand) throws DataAccessException{
		//게시글 작성
		goodsMapper.insertUsedGoods(goodsCommand);
	}

	@Override
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand) throws DataAccessException{
		//게시글 수정
		goodsMapper.updateUsedGoods(goodsCommand);
	}

	@Override
	public void deleteUsedGoods(int g_id) throws DataAccessException{
		//게시글 삭제
		goodsMapper.deleteUsedGoods(g_id);
	}

}
