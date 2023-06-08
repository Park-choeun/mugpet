<<<<<<< HEAD
package com.spring.mugpet.service;

import java.util.List;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.domain.Community;

public interface CommunityService {
	public List<Community> getComList();
	
	public List<Community> getMemberComList(int u_id);
	
	public Community getCom(int com_id);
	
	public void insertCom(NewCommunityCommand comCommand);
	
	public void updateCom(NewCommunityCommand comCommand);
	
	public void deleteCom(int com_id);
}
=======
package com.spring.mugpet.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.controller.community.NewCommunityCommand;
import com.spring.mugpet.domain.Community;

public interface CommunityService {
	
	public List<Community> getComList();
	
	public List<Community> getMemberComList(int u_id);
	
	public Community getCom(int com_id);
	
	public void insertCom(NewCommunityCommand comCommand, MultipartFile file) throws Exception;
	
	public void updateCom(NewCommunityCommand comCommand);
	
	public void deleteCom(int com_id);
	
	public int getU_IdByCommunity(int com_id);
}
>>>>>>> main
