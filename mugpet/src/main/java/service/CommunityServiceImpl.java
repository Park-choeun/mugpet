package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommunityDAO;
import domain.Community;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired
	private CommunityDAO communityDAO;
	
	public List<Community> getComList(){
		return communityDAO.getComList();
	}
	
	public List<Community> getMemberComList(int u_id){
		return communityDAO.getMemberComList(u_id);
	}
	
	public Community getCom(Community com) {
		return communityDAO.getCom(com);
	}
	
	public void insertCom(Community com) {
		communityDAO.insertCom(com);
	}
	
	public void updateCom(int com_id) {
		communityDAO.updateCom(com_id);
	}
	
	public void deleteCom(int com_id) {
		communityDAO.deleteCom(com_id);
	}
}