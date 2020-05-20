package com.nguyenphucthienan.springpetclinic.services.map;

import com.nguyenphucthienan.springpetclinic.model.Pet;
import com.nguyenphucthienan.springpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
}
