<<<<<<< HEAD
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
=======
package com.spring.mugpet.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.dao.CommunityDao;
import com.spring.mugpet.domain.Community;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityDao communityDAO;
	//각자 path에서 맞게 수정
	private final String CURR_IMAGE_REPO_PATH = "/Users/82102/test/";
	
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
	public void insertCom(NewCommunityCommand comCommand, MultipartFile file) throws Exception{
		String imgFileName = file.getOriginalFilename();
		
		//들어왔는지 체크
		System.out.println(imgFileName);
		
		UUID uuid = UUID.randomUUID();
		
		String saveFileName = uuid + "_" + "imgFileName";
		comCommand.setImageUrl(saveFileName);
		File saveImgfile = new File(CURR_IMAGE_REPO_PATH + saveFileName);
		
		//체크
		System.out.println(saveImgfile);
		
		file.transferTo(saveImgfile);
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

	@Override
	public int getU_IdByCommunity(int com_id) {
		return communityDAO.getU_IdByCommunity(com_id);
		
	}
>>>>>>> main
}