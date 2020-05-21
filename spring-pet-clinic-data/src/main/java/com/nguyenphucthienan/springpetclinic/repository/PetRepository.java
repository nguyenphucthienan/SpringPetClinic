package com.nguyenphucthienan.springpetclinic.repository;

import com.nguyenphucthienan.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
