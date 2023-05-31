package com.spring.mugpet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.domain.Reply;


public interface ReplyDao { 
	public List<Reply> getCommunityReplyList(int com_id) throws DataAccessException; //각 커뮤니티 글에 대한 댓글 목록
  
	public List<Reply> getUsedGoodsReplyList(int g_id) throws DataAccessException;
	
	public void insertComReply(NewReplyCommand replyCommand) throws DataAccessException; //댓글 작성
  
	public void insertGoodsReply(NewReplyCommand replyCommand) throws DataAccessException;
	
	public void deleteComReply(int rp_id, int com_id) throws DataAccessException; //댓글 삭제 
	
	public void deleteGoodsReply(int rp_id, int g_id) throws DataAccessException;
}