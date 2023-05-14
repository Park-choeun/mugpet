package service;

import java.util.List;

import domain.Reply;

public interface ReplyService {
	public List<Reply> getReplyList(int com_id);
	
	public void insertReply(Reply reply);
	
	public void deleteReply(int rp_id);
}
