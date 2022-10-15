package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.VisitService;

public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService {

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		if (object != null) {
			if (object.getPet() == null || object.getPet().getId() == null) {
				throw new RuntimeException("Pet Id is Required");
			} else if (object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null) {
				throw new RuntimeException("Owner Id is Required");
			} else {
				return super.save(object);
			}
		}
		else {
			throw new RuntimeException("Invalid Visit object");
		}
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	Long getNextId() {
		return super.getNextId();
	}

}
