package com.nguyenphucthienan.springpetclinic.service.map;

import com.nguyenphucthienan.springpetclinic.model.Speciality;
import com.nguyenphucthienan.springpetclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map", "default"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
