package guru.springframework.sfgpetclinic.service;

import java.util.List;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService <Owner,Long>{
	Owner findByLastName(String lastName);
	List<Owner> findAllByLastNameLike(String lastName);
}
