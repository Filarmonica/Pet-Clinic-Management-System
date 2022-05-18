package com.sda.petclinic.service;

import com.sda.petclinic.model.Client;
import com.sda.petclinic.repository.ClientRepository;
import com.sda.petclinic.repository.ClientRepositoryImpl;
import com.sda.petclinic.repository.PetRepository;
import com.sda.petclinic.repository.PetRepositoryImpl;
import com.sda.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.Optional;

public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    public PetServiceImpl() {
        this.petRepository = new PetRepositoryImpl();
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException {
        if (race == null || race.isBlank()) {
            throw new InvalidParameterException("The race is null or blank.");
        }
        if (birthDate == null) {
            throw new InvalidParameterException("The birthDate is null");
        }
        if (birthDate.after(new Date())) {
            throw new InvalidParameterException("The birthDate is in the future");
        }
        if (ownerFirstName == null || ownerFirstName.isBlank()) {
            throw new InvalidParameterException("The owner first name is null or blank.");
        }
        if (ownerLastName == null || ownerLastName.isBlank()) {
            throw new InvalidParameterException("The owner last name is null or blank.");
        }

        Optional<Client> clientResult = clientRepository.findByFirstNameAndLastName(ownerFirstName,ownerLastName);
        if(clientResult.isEmpty()){
            Client client = new Client(ownerFirstName,ownerLastName,null,null);
            clientRepository.create(client);
        }
    }
}