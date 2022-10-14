package guru.springframework.sfgpetclinic.service.map.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repository.PetTypeRepository;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService{

	private final PetTypeRepository petTypeRepository;
	
	
	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> pettypes = new HashSet<>();
		petTypeRepository.findAll().forEach(pettypes::add);
		return pettypes;
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}


}
