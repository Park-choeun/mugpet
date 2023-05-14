package dao;

import java.util.List;

import domain.UsedGoods;

/*UsedGoods를 위한 DAO interface*/
public interface UsedGoodsDAO {
	public List<UsedGoods> getUsedGoodsList(); /*전체 중고거래 글 목록*/
	
	public List<UsedGoods> getMemberUsedGoodsList(int u_id); /*member가 쓴 중고거래 글 목록*/
	
	public UsedGoods getUsedGoods(UsedGoods goods); /*중고거래 글 상세보기 -> 로그인한 id와 u_id가 같으면 수정 가능*/
	
	public void insertUsedGoods(UsedGoods goods); /*중고거래 글 작성*/
	
	public void updateUsedGoods(UsedGoods goods); /*중고거래 글 수정*/
	
	/*삭제시엔 g_id만 있어도 되지 않나?*/
	public void deleteUsedGoods(UsedGoods goods); /*중고거래 글 삭제*/
}
