package com.nguyenphucthienan.springpetclinic.service;

import com.nguyenphucthienan.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
