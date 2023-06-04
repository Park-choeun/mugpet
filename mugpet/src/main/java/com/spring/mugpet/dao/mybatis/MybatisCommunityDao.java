package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.dao.CommunityDao;
import com.spring.mugpet.dao.mybatis.mapper.CommunityMapper;
import com.spring.mugpet.domain.Community;

@Repository
public class MybatisCommunityDao implements CommunityDao{
	@Autowired
	private CommunityMapper comMapper;
	
	@Override
	public List<Community> getComList() throws DataAccessException{
		//게시글 목록 보기
		return comMapper.getComList();
	}

	@Override
	public List<Community> getMemberComList(int u_id) throws DataAccessException{
		//본인이 쓴 게시글 목록 보기
		return comMapper.getMemberComList(u_id);
	}

	@Override
	public Community getCom(int com_id) throws DataAccessException{
		//게시글 상세보기
		return comMapper.getCom(com_id);
	}

	@Override
	public void insertCom(NewCommunityCommand comCommand) throws DataAccessException{
		//게시글 작성
		comMapper.insertCom(comCommand);
		
	}

	@Override
	public void updateCom(NewCommunityCommand comCommand) throws DataAccessException{
		//게시글 수정
		comMapper.updateCom(comCommand);
		
	}

	@Override
	public void deleteCom(int com_id) throws DataAccessException{
		//게시글 삭제
		comMapper.deleteCom(com_id);
		
	}

	@Override
	public void updateReplyCnt(int com_id, int amount) {
		//댓글 수
		comMapper.updateReplyCnt(com_id, amount);
		
	}	
}