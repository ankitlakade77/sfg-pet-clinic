package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	void delete(Pet object) {
		super.delete(object);
	}

}
