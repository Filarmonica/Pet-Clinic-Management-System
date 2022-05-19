package com.sda.petclinic.service;

import com.sda.petclinic.model.Pet;

import java.util.List;

public interface ClientService {

    List<Pet> findPetsForClientId(Long clientId);
}
