package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

	private PetType PetType;
	private Owner owner;
	private LocalDate birthDate;
	
	public PetType getPetType() {
		return PetType;
	}
	public void setPetType(PetType petType) {
		PetType = petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
