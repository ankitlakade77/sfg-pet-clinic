package guru.springframework.sfgpetclinic.service.map;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Service
@Profile("default")
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService{
	
	private PetTypeService petTypeService;
	private PetService petService;
	
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream()
				.filter(p -> p.getLastName().equals(lastName))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet-> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						} 
						
						if(pet.getId() == null) {
							Pet savedPet = petService.save(pet);
							pet.setId(savedPet.getId());
						}
						
					}
					else {
						throw new RuntimeException("Pet Type is Required");
					}
				});
			}
			return super.save(object);
		}
		else {
			return null;
		}
	}

	
	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}
	
}
