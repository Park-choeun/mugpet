package com.spring.mugpet.dao;

import org.springframework.dao.DataAccessException;

import com.spring.mugpet.domain.Pet;

public interface PetDao {


	public void insertPet(Pet pet)throws DataAccessException;
}
