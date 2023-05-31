package com.spring.mugpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.dao.CommunityDao;
import com.spring.mugpet.domain.Community;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired
	private CommunityDao communityDAO;
	
	@Override
	public List<Community> getComList(){
		return communityDAO.getComList();
	}
	
	@Override
	public List<Community> getMemberComList(int u_id){
		return communityDAO.getMemberComList(u_id);
	}
	
	@Override
	public Community getCom(int com_id) {
		return communityDAO.getCom(com_id);
	}
	
	@Override
	public void insertCom(NewCommunityCommand comCommand) {
		communityDAO.insertCom(comCommand);
	}
	
	@Override
	public void updateCom(NewCommunityCommand comCommand) {
		communityDAO.updateCom(comCommand);
	}
	
	@Override
	public void deleteCom(int com_id) {
		communityDAO.deleteCom(com_id);
	}
}