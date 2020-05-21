package com.nguyenphucthienan.springpetclinic.service.map;

import com.nguyenphucthienan.springpetclinic.model.Owner;
import com.nguyenphucthienan.springpetclinic.model.Pet;
import com.nguyenphucthienan.springpetclinic.service.OwnerService;
import com.nguyenphucthienan.springpetclinic.service.PetService;
import com.nguyenphucthienan.springpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) {
            return null;
        }

        object.getPets().forEach(pet -> {
            if (pet.getPetType() == null) {
                throw new RuntimeException("PetType is required");
            }

            if (pet.getPetType().getId() == null) {
                pet.setPetType(petTypeService.save(pet.getPetType()));
            }

            if (pet.getId() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });

        return super.save(object);
    }
}
