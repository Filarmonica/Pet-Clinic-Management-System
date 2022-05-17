package com.sda.petclinic.service;

import com.sda.petclinic.service.dto.VeterinarianDto;
import java.security.InvalidParameterException;
import java.util.List;

public interface VeterinarianService {

    void create(String firstName,String lastName,String address, String speciality) throws InvalidParameterException;

    List<VeterinarianDto> findAll();

    void deleteById(Long id);

    void update(long id, String firstName, String lastName, String address, String speciality) throws InvalidParameterException;
}
