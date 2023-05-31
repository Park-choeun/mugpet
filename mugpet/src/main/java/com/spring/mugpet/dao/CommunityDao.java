package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.domain.Community;

public interface CommunityDao {
	public List<Community> getComList() throws DataAccessException; /*커뮤니티 전체 글 목록*/
	
	public List<Community> getMemberComList(int u_id) throws DataAccessException; /*member가 쓴 글 목록*/
	
	public Community getCom(int com_id) throws DataAccessException; /*글 상세보기*/
	
	public void insertCom(NewCommunityCommand comCommand) throws DataAccessException; /*커뮤니티 글 추가*/
	
	public void updateCom(NewCommunityCommand comCommand) throws DataAccessException; /*커뮤니티 글 수정*/
	
	public void deleteCom(int com_id) throws DataAccessException; /*커뮤니티 글 삭제*/

	public void updateReplyCnt(int com_id, int amount);
}
