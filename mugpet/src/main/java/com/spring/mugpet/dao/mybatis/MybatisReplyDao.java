package com.spring.mugpet.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mugpet.controller.community.NewReplyCommand;
//import com.spring.mugpet.dao.ReplyDao;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.dao.ReplyDao;
import com.spring.mugpet.dao.mybatis.mapper.CommunityMapper;
import com.spring.mugpet.dao.mybatis.mapper.ReplyMapper;

@Repository
public class MybatisReplyDao implements ReplyDao{
	@Autowired
	private ReplyMapper replyMapper;
	
	@Autowired
	private CommunityMapper comMapper;
	
	@Override
	public List<Reply> getCommunityReplyList(int com_id) throws DataAccessException{
		//댓글 목록 보기
		return replyMapper.getCommunityReplyList(com_id);
	}
	
	@Override
	public List<Reply> getUsedGoodsReplyList(int g_id) throws DataAccessException{
		//댓글 목록 보기
		return replyMapper.getUsedGoodsReplyList(g_id);
	}
	
	@Override
	public void insertComReply(NewReplyCommand replyCommand) throws DataAccessException{
		//댓글 작성
		comMapper.updateReplyCnt(replyCommand.getCom_id(), 1);
		replyMapper.insertComReply(replyCommand);
	}
	
	@Override
	@Transactional
	public void insertGoodsReply(NewReplyCommand replyCommand) throws DataAccessException{
		//댓글 작성
		replyMapper.insertGoodsReply(replyCommand);
	}
	
	@Override
	@Transactional
	public void deleteComReply(int rp_id, int com_id) throws DataAccessException{
		//댓글 삭제
		comMapper.updateReplyCnt(com_id, -1);
		replyMapper.deleteComReply(rp_id, com_id);
	}

	@Override
	public void deleteGoodsReply(int rp_id, int g_id) throws DataAccessException{
		//댓글 삭제
		replyMapper.deleteGoodsReply(rp_id, g_id);
	}
}
