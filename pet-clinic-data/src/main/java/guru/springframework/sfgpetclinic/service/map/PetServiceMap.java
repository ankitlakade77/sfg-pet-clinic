package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;

@Service
@Profile("default")
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet object) {
		return super.save(object);
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
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

}
