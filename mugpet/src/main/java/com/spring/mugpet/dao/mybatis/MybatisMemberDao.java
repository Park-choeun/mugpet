package com.spring.mugpet.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.MemberDao;
import com.spring.mugpet.dao.mybatis.mapper.MemberMapper;
import com.spring.mugpet.domain.MemberInfo;

@Repository
public class MybatisMemberDao implements MemberDao{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void insertAccount(MemberInfo account) {
		memberMapper.insertAccount(account);
	}

	@Override
	public MemberInfo getMemberInfoByEmailandPwd(String email,String pwd) {
		return memberMapper.getMemberInfoByEmailandPwd(email,pwd);
	}
	
	@Override
	public void updatePoints(int point, String email, String pwd) {
		memberMapper.updatePoints(point, email, pwd);
	}
	
	@Override
	public String getNickNameByU_Id(int u_id) {
		return memberMapper.getNickNameByU_Id(u_id);
	}
	
}
