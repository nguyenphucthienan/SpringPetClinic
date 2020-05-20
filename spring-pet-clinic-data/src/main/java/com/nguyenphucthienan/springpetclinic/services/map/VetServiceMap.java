package com.nguyenphucthienan.springpetclinic.services.map;

import com.nguyenphucthienan.springpetclinic.model.Vet;
import com.nguyenphucthienan.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }
}
