package domain;

/*Pet Domain 클래스*/
public class Pet {
	private int pet_id;
	private String name;
	private String species;
	private String birth;
	
	public Pet() {
		
	}

	public Pet(int pet_id, String name, String species, String birth) {
		super();
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
