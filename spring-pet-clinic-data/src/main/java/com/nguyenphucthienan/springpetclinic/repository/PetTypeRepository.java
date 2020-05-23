package com.nguyenphucthienan.springpetclinic.repository;

import com.nguyenphucthienan.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
