package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream().filter(p -> p.getLastName().equals(lastName)).findFirst().orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
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
	void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	void delete(Owner object) {
		super.delete(object);
	}
	
}
