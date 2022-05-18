package com.sda.petclinic.repository;

import com.sda.petclinic.model.Pet;
import com.sda.petclinic.repository.base.BaseRepositoryImpl;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
