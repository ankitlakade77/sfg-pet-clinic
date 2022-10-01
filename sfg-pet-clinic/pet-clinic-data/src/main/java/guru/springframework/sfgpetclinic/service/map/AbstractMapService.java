package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	T findById(ID id) {
		return map.get(id);
	}

	T save(T object) {

		if (object != null) {
			if (object.getId() == null) {

				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		return object;
	}

	Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	void deleteById(ID id) {
		map.remove(id);
	}

	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	Long getNextId() {
		Long nextId=null;
		try {
			nextId=Collections.max(map.keySet())+1;
		} catch(NoSuchElementException e) {
			nextId=1L;
		}
		return nextId;
	}
}
