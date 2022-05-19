package com.sda.petclinic.service;

import com.sda.petclinic.model.Pet;
import com.sda.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;

public interface PetService {

    void create (String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException;

    List<Pet> findAllVaccinated();
}
