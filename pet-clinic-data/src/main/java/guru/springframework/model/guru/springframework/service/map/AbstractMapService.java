package guru.springframework.model.guru.springframework.service.map;

import guru.springframework.model.Owner;

import java.util.*;

public class AbstractMapService<T, ID> {
    Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet(map.values());
    }

    T findById(ID id) {
        return (T) map.get(id);
    }
    T save(ID id, T t) {
        map.put(id, t);
        return t;
    }
    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(tidEntry -> tidEntry.getValue().equals(object));
    }
}
