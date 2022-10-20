package guru.springframework.sfgpetclinic.service.map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerServiceMap;
	
	 final Long ownerId = 1L;
	 final String lastName = "Smith";
	 final String firstName = "Deven";
	
	@BeforeEach
	void setUp() throws Exception {
		this.ownerServiceMap=new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		Owner owner=new Owner();
		owner.setId(ownerId);
		owner.setFirstName(firstName);
		owner.setLastName(lastName);
		this.ownerServiceMap.save(owner);
	}

	@Test
	void testFindByLastName() {
		Owner owner=ownerServiceMap.findByLastName(lastName);
		assertEquals(owner.getLastName(),lastName);
	}

	@Test
	void testSaveOwner() {
		ownerServiceMap.save(new Owner());
		assertEquals(ownerServiceMap.findAll().size(),2);
	}

	@Test
	void testFindByIdLong() {
		Owner owner=ownerServiceMap.findById(1L);
		assertEquals(owner.getId(),ownerId);
	}

	@Test
	void testFindAll() {
		assertEquals(ownerServiceMap.findAll().size(),1);
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(ownerServiceMap.findAll().size(),0);
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(1L));
		assertEquals(ownerServiceMap.findAll().size(),0);
	}

}
