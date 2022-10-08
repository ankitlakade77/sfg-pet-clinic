package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.service.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService{

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	void delete(Speciality object) {
		super.delete(object);
	}

	@Override
	Long getNextId() {
		return super.getNextId();
	}

}
