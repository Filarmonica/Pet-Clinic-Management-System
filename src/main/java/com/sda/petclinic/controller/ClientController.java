package com.sda.petclinic.controller;

import com.sda.petclinic.service.ClientService;
import com.sda.petclinic.service.ClientServiceImpl;

import java.util.Scanner;

public class ClientController {
    private final ClientService clientService;
    Scanner scanner;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void viewAllPetsForClient() {
        try {
            System.out.println("PLease insert clinet ID: ");
            Long inputClientId = Long.parseLong(scanner.nextLine());
            clientService.findPetsForClientId(inputClientId)
                    .stream()
                    .forEach(pet -> System.out.println(pet));

        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid client ID.");
        } catch (Exception e) {
            System.out.println("Internal Server Error.");
        }
    }
}
