package com.nguyenphucthienan.springpetclinic.service.map;

import com.nguyenphucthienan.springpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public HashSet<T> findAll() {
        return new HashSet<T>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if (object == null) {
            throw new RuntimeException("Object cannot be null");
        }

        if (object.getId() == null) {
            object.setId(getNextId());
        }

        map.put(object.getId(), object);
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return map.keySet().size() > 0 ? Collections.max(map.keySet()) + 1 : 1L;
    }
}
