package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="Pets")
public class Pet extends BaseEntity{

	@ManyToOne
	@JoinTable(name = "pettype_id")
	private PetType PetType;
	
	@ManyToOne
	@JoinColumn(name ="owner_id")
	private Owner owner;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "name")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
