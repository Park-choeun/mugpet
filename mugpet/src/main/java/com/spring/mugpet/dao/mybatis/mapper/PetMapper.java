package com.spring.mugpet.dao.mybatis.mapper;

import com.spring.mugpet.domain.Pet;

public interface PetMapper {

	
	void insertPet(Pet pet);
	Pet getPetByU_id(int u_id);
	
	
	
}
