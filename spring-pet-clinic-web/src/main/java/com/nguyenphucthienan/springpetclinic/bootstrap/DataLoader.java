package com.nguyenphucthienan.springpetclinic.bootstrap;

import com.nguyenphucthienan.springpetclinic.model.Owner;
import com.nguyenphucthienan.springpetclinic.model.PetType;
import com.nguyenphucthienan.springpetclinic.model.Vet;
import com.nguyenphucthienan.springpetclinic.services.OwnerService;
import com.nguyenphucthienan.springpetclinic.services.PetTypeService;
import com.nguyenphucthienan.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(PetTypeService petTypeService, OwnerService ownerService, VetService vetService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");

        PetType catPetType = new PetType();
        catPetType.setName("Cat");

        PetType savedDogPetType = petTypeService.save(dogPetType);
        PetType savedCatPetType = petTypeService.save(catPetType);

        Owner owner = new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner);
        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet);
        vetService.save(vet2);
    }
}
