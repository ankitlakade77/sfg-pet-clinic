package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="visits")
public class Visit extends BaseEntity {
	
	@Column(name="date")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	@Column(name="description")
	private String description;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
