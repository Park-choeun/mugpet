package service;

import java.util.List;

import domain.Community;

public interface CommunityService {
	public List<Community> getComList();
	
	public List<Community> getMemberComList(int u_id);
	
	public Community getCom(Community com);
	
	public void insertCom(Community com);
	
	public void updateCom(int com_id);
	
	public void deleteCom(int com_id);
}
