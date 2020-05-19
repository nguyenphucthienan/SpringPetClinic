package com.nguyenphucthienan.springpetclinic.services;

import com.nguyenphucthienan.springpetclinic.model.Pet;
import com.nguyenphucthienan.springpetclinic.model.Owner;

import java.util.Set;

public interface PetService {

    Set<Owner> findAll();

    Pet findById(Long id);

    Pet save(Pet pet);
}
