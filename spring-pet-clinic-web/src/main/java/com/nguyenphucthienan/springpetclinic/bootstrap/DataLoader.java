package com.nguyenphucthienan.springpetclinic.bootstrap;

import com.nguyenphucthienan.springpetclinic.model.Owner;
import com.nguyenphucthienan.springpetclinic.model.Vet;
import com.nguyenphucthienan.springpetclinic.services.OwnerService;
import com.nguyenphucthienan.springpetclinic.services.VetService;
import com.nguyenphucthienan.springpetclinic.services.map.OwnerServiceMap;
import com.nguyenphucthienan.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner);
        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sam");
        vet.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet);
        vetService.save(vet2);
    }
}
