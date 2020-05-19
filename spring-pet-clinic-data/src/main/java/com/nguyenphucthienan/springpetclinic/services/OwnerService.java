package com.nguyenphucthienan.springpetclinic.services;

import com.nguyenphucthienan.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Set<Owner> findAll();

    Owner findById(Long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

}
