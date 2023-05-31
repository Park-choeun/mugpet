package com.spring.mugpet.dao;

import java.util.List;

import com.spring.mugpet.controller.usedgoods.NewUsedGoodsCommand;
import com.spring.mugpet.domain.UsedGoods;

public interface UsedGoodsDao {
	public List<UsedGoods> getUsedGoodsList(); /*전체 중고거래 글 목록*/
	
	public List<UsedGoods> getMemberUsedGoodsList(int u_id); /*member가 쓴 중고거래 글 목록*/
	
	public UsedGoods getUsedGoods(int g_id); /*중고거래 글 상세보기 -> 로그인한 id와 u_id가 같으면 수정 가능*/
	
	public void insertUsedGoods(NewUsedGoodsCommand goodsCommand); /*중고거래 글 작성*/
	
	public void updateUsedGoods(NewUsedGoodsCommand goodsCommand); /*중고거래 글 수정*/
	
	public void deleteUsedGoods(int g_id); /*중고거래 글 삭제*/
}
