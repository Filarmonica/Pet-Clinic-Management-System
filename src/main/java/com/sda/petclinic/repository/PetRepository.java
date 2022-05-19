package com.sda.petclinic.repository;

import com.sda.petclinic.model.Pet;
import com.sda.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface PetRepository extends BaseRepository<Pet, Long> {

     List<Pet> findAllVaccinated();


}
