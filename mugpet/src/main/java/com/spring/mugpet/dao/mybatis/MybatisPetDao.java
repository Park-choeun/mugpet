package com.spring.mugpet.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mugpet.dao.PetDao;
import com.spring.mugpet.dao.mybatis.mapper.PetMapper;
import com.spring.mugpet.domain.Pet;

@Repository
public class MybatisPetDao implements PetDao{

	
	@Autowired
	private PetMapper petMapper;

	@Override
	public void insertPet(Pet pet) throws DataAccessException{
		petMapper.insertPet(pet);
		
	}
	
	
	
}
