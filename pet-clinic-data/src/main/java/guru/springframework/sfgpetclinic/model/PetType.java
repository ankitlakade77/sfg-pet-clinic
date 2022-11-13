package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;

@Entity
@Table(name="pet_types")
public class PetType extends BaseEntity{
	
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
