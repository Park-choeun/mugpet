package com.spring.mugpet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mugpet.dao.PetDao;
import com.spring.mugpet.domain.Pet;


@Service
public class PetServiceImpl implements PetService {

	
	@Autowired
	private PetDao petDao;
	
	@Override
	public void addPet(Pet pet) {
		petDao.insertPet(pet);

	}
	
	

}
