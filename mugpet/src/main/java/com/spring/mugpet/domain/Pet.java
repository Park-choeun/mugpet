package com.spring.mugpet.domain;

public class Pet {
	private int pet_id;			//primary key
	private String name;		//반려동물 이름
	private String species;		//반려동물 종(강아지 or 고양이 or 소동물)
	private String birth;		//반려동물 생일
	
	public Pet() {}

	public Pet(int pet_id, String name, String species, String birth) {
		this.pet_id = pet_id;
		this.name = name;
		this.species = species;
		this.birth = birth;
	}

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
}