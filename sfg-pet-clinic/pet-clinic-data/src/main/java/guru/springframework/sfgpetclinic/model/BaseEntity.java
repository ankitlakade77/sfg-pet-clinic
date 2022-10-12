package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
}
