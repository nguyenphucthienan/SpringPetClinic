package com.nguyenphucthienan.springpetclinic.services.map;

import com.nguyenphucthienan.springpetclinic.model.Speciality;
import com.nguyenphucthienan.springpetclinic.model.Vet;
import com.nguyenphucthienan.springpetclinic.services.SpecialityService;
import com.nguyenphucthienan.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if (object == null) {
            return null;
        }

        object.getSpecialities().forEach(speciality -> {
            if (speciality.getId() == null) {
                Speciality saveSpeciality = specialityService.save(speciality);
                speciality.setId(saveSpeciality.getId());
            }
        });

        return super.save(object);
    }
}
