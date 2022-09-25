package guru.springframework.sfgpetclinic.service.map;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;


public abstract class AbstractMapService<T, ID> {
	
	protected Map<ID, T> map = new HashMap<>();
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(ID id,T object) {
		map.put(id, object);
		return object;
	}
	
	Set<T> findAll(){
		return new HashSet<T>(map.values());
	}

	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
}
