package com.sda.petclinic.controller;

import com.sda.petclinic.service.PetService;
import com.sda.petclinic.service.PetServiceImpl;
import com.sda.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetController {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private final PetService petService;
    private final Scanner scanner;

    public PetController() {
        this.petService = new PetServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void addPet() {
        //String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName

        try {
            System.out.println("Please insert race: ");
            String raceInput = scanner.nextLine();

            System.out.println("Please insert date of birth: ");
            String dateInput = scanner.nextLine();
            Date birthDate = FORMATTER.parse(dateInput);

            System.out.println("Please insert true if the pet is vaccinated or false otherwise: ");
            boolean isVaccinatedState = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Please insert the owner's first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert the owner's last name: ");
            String lastName = scanner.nextLine();

            petService.create(raceInput, birthDate, isVaccinatedState, firstName, lastName);


        } catch (ParseException e) {
            System.out.println("Please insert a correct date of birth " + DATE_FORMAT);
        } catch (InputMismatchException e) {
            System.out.println("Please insert true or false for the vaccinated status.");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error.");
            e.printStackTrace();
        }
    }
    public void showAllVaccinated(){
        petService.findAllVaccinated()
                .stream()
                .forEach(pet ->
                        System.out.println(
                                "race: "+pet.getRace()+
                                " Date of Birth: "+ FORMATTER.format(pet.getDateOfBirth())+
                                " Vaccinated?: "+(pet.getVaccinated()?"Yes":"No")));
    }
}