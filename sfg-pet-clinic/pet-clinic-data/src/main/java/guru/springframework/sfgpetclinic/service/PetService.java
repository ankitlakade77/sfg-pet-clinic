package guru.springframework.sfgpetclinic.service;

import java.util.Set;
import guru.springframework.sfgpetclinic.model.Pet;

public interface PetService {
	Pet findById(Long Id);
	Pet save(Pet pet);
	Set<Pet> findAll();
}
