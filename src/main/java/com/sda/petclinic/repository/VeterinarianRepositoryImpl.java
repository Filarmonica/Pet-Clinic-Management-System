package com.sda.petclinic.repository;

import com.sda.petclinic.model.Veterinarian;
import com.sda.petclinic.repository.base.BaseRepositoryImpl;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}
