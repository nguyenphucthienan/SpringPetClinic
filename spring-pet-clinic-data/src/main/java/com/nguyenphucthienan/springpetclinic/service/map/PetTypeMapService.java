package com.nguyenphucthienan.springpetclinic.service.map;

import com.nguyenphucthienan.springpetclinic.model.PetType;
import com.nguyenphucthienan.springpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
