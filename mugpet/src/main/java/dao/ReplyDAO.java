package dao;

import java.util.List;

import domain.Reply;

/*Reply를 위한 DAO interface*/
public interface ReplyDAO {
	public List<Reply> getReplyList(int com_id); /*각 커뮤니티 글에 대한 댓글 목록*/
	
	public void insertReply(Reply reply); /*댓글 작성*/
	
	public void deleteReply(int rp_id); /*댓글 삭제*/
}
