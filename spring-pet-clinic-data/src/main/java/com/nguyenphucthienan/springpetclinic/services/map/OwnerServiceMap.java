package com.nguyenphucthienan.springpetclinic.services.map;

import com.nguyenphucthienan.springpetclinic.model.Owner;
import com.nguyenphucthienan.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }
}
