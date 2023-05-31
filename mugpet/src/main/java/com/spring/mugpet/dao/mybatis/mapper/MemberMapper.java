package com.spring.mugpet.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberMapper {

	
	void insertAccount(MemberInfo account);
	MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);
}
