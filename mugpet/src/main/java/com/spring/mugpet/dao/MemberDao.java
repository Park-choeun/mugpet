package com.spring.mugpet.dao;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberDao {
	public void insertAccount(MemberInfo account);
	public MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);
	public void updatePoints(int point,String email, String pwd);
	//Community, UsedGoods에서 사용
	public String getNickNameByU_Id(int u_id);

}

