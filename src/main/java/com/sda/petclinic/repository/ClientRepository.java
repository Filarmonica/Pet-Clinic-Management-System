package com.sda.petclinic.repository;

import com.sda.petclinic.model.Client;
import com.sda.petclinic.repository.base.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long> {

    Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);

}
