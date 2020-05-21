package com.nguyenphucthienan.springpetclinic.service.map;

import com.nguyenphucthienan.springpetclinic.model.Speciality;
import com.nguyenphucthienan.springpetclinic.model.Vet;
import com.nguyenphucthienan.springpetclinic.service.SpecialityService;
import com.nguyenphucthienan.springpetclinic.service.VetService;
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
