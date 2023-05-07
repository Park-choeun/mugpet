package controller.member;

public class NewPetCommand {
	
	private String name;
	private String species;
	private String birth;
	
	
	
	
	public NewPetCommand(String name, String species, String birth) {
		super();
		this.name = name;
		this.species = species;
		this.birth = birth;
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
