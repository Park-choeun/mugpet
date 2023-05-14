package dao;

import java.util.List;

import domain.Community;

/*Community를 위한 DAO interface*/
public interface CommunityDAO {
	public List<Community> getComList(); /*커뮤니티 전체 글 목록*/
	
	public List<Community> getMemberComList(int u_id); /*member가 쓴 글 목록*/
	
	public Community getCom(Community com); /*글 상세보기 -> 로그인한 id와 u_id가 같으면 수정 가능*/
	
	public void insertCom(Community com); /*커뮤니티 글 추가*/
	
	public void updateCom(int com_id); /*커뮤니티 글 수정*/
	
	public void deleteCom(int com_id); /*커뮤니티 글 삭제*/
}
