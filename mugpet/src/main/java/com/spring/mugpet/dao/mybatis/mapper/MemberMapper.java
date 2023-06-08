<<<<<<< HEAD
package com.spring.mugpet.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberMapper {

	
	void insertAccount(MemberInfo account);
	MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);
	void updatePoints(@Param("point")int point, @Param("email")String email, @Param("pwd") String pwd);
}
=======
package com.spring.mugpet.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.domain.MemberInfo;

public interface MemberMapper {

	
	void insertAccount(MemberInfo account);
	MemberInfo getMemberInfoByEmailandPwd(String email,String pwd);
	void updatePoints(@Param("point")int point, @Param("email")String email, @Param("pwd") String pwd);

	//Community, UsedGoods에서 사용
	String getNickNameByU_Id(int u_id);

}
>>>>>>> main
