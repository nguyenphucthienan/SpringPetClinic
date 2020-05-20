package com.nguyenphucthienan.springpetclinic.bootstrap;

import com.nguyenphucthienan.springpetclinic.model.Owner;
import com.nguyenphucthienan.springpetclinic.model.Pet;
import com.nguyenphucthienan.springpetclinic.model.PetType;
import com.nguyenphucthienan.springpetclinic.model.Vet;
import com.nguyenphucthienan.springpetclinic.services.OwnerService;
import com.nguyenphucthienan.springpetclinic.services.PetTypeService;
import com.nguyenphucthienan.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner);
        owner.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("456456456");

        Pet fionasPet = new Pet();
        fionasPet.setName("Mimi");
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        owner2.getPets().add(fionasPet);

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
