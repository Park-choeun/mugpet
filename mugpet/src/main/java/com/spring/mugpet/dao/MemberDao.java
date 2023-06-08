package com.spring.mugpet.dao;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberDao {
	public void insertAccount(MemberInfo account);
	public MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);
	public void updatePoints(int point,String email, String pwd);
}
