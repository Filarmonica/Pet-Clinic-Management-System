package com.sda.petclinic.service;

import com.sda.petclinic.model.Client;
import com.sda.petclinic.model.Pet;
import com.sda.petclinic.repository.ClientRepository;
import com.sda.petclinic.repository.ClientRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public List<Pet> findPetsForClientId(Long clientId) {
        Optional<Client> client = clientRepository.findByIdAndLoadPets(clientId);
        if(client.isPresent()){
            return client.get().getPets();
        }
        return new ArrayList<>();
    }
}
