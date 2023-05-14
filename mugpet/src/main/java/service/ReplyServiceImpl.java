package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReplyDAO;
import domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public List<Reply> getReplyList(int com_id) {
		return replyDAO.getReplyList(com_id);
	}

	@Override
	public void insertReply(Reply reply) {
		replyDAO.insertReply(reply);
	}

	@Override
	public void deleteReply(int rp_id) {
		replyDAO.deleteReply(rp_id);
	}
	
}
