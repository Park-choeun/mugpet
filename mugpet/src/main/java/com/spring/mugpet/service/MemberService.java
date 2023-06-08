package com.spring.mugpet.service;


import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberService {

	
	public boolean login(String email,String pwd);
	public MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);
	public void creatAccount(MemberInfo account,MultipartFile file) throws Exception;
	public void creatAccountWithoutImgFile(MemberInfo account) throws Exception;
	public void updateAccount(MemberInfo account);
	public MemberInfo checkAccount(String email, String pwd);
	public void updatePoints(int point, String email, String pwd);
}
