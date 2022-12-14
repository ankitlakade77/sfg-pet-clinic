package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;

@MappedSuperclass
public class Person extends BaseEntity{
	
	public Person(Long Id, String firstName, String lastName) {
		super(Id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person() {
	}
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
