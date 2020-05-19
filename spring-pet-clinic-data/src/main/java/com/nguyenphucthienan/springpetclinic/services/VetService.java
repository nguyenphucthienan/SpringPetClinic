package com.nguyenphucthienan.springpetclinic.services;

import com.nguyenphucthienan.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();

    Vet findById(Long id);

    Vet save(Vet vet);
}
