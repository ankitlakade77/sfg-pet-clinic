package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService{

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	void delete(PetType object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	Long getNextId() {
		// TODO Auto-generated method stub
		return super.getNextId();
	}


}
