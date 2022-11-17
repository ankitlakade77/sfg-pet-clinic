package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Pets")
public class Pet extends BaseEntity{
	
	public Pet(Long id,PetType petType, Owner owner, LocalDate birthDate, String name,
			Set<Visit> visits) {
		super(id);
		PetType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
		this.name = name;
		this.visits = visits;
	}
	
	public Pet() {}
	
	@ManyToOne
	@JoinColumn(name = "types_id")
	private PetType PetType;
	
	@ManyToOne
	@JoinColumn(name ="owner_id")
	private Owner owner;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pet")
	Set<Visit> visits=new HashSet<>();
	
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
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	
	
}
