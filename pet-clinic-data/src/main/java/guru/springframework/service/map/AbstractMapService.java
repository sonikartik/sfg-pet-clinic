package guru.springframework.service.map;

import guru.springframework.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
    Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet(map.values());
    }

    T findById(ID id) {
        return (T) map.get(id);
    }

    T save(T t) {
        if (t != null) {
            if (t.getId() == null) {
                t.setId(getNextId());
            }
            map.put(t.getId(), t);
        } else {
            throw new RuntimeException("Object Cannot be null");
        }

        return t;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(tidEntry -> tidEntry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
