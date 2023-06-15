package com.spring.mugpet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.mugpet.controller.community.NewReplyCommand;
import com.spring.mugpet.domain.Reply;

public interface ReplyMapper {
	public List<Reply> getCommunityReplyList(int com_id); /*각 커뮤니티 글에 대한 댓글 목록*/
	
	public List<Reply> getUsedGoodsReplyList(int g_id);
	
	public void insertComReply(NewReplyCommand replyCommand); /*댓글 작성*/
	
	public void insertGoodsReply(NewReplyCommand replyCommand);
	
	public void deleteComReply(@Param("rp_id") int rp_id, @Param("com_id") int com_id); /*댓글 삭제*/
	
	public void deleteGoodsReply(@Param("rp_id") int rp_id, @Param("g_id") int g_id);
	
	public int getU_IdByCommunityReply(@Param("com_id") int com_id, @Param("rp_id") int rp_id);
	
	public int getU_IdByUsedGoodsReply(@Param("g_id") int g_id, @Param("rp_id") int rp_id);
	
	public List<Reply> getMyReplyList(int u_id);
}
