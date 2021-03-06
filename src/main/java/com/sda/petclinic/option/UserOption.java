package com.sda.petclinic.option;

import java.util.Arrays;
import java.util.Optional;

public enum UserOption {
    ADD_NEW_VET("Add new Veterinarian", 1),
    SHOW_ALL("Display all veterinarians", 2),
    DELETE_ID("Delete veterinarian by ID", 3),
    UPDATE("Update existing veterinarian",4),
    ADD_NEW_PET("Add a new pet", 5),
    VIEW_ALL_VACCINATED("View all vaccinated pets", 6),
    VIEW_ALL_PETS_FOR_CLIENT_ID("View pets by client ID", 7),
    EXIT("Exit", 999),
    UNKNOWN("Unknown option, try again",  1000);

    public final String prettyName;
    private final int optionNumber;

    UserOption(String prettyName, int optionNumber) {
        this.prettyName = prettyName;
        this.optionNumber = optionNumber;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOptionNumber() {
        return optionNumber;
    }
    public static void printAlloptions(){
        System.out.println("+-----------------------------+");
        Arrays.stream(UserOption.values())
                .filter(userOption -> !UserOption.UNKNOWN.equals(userOption))
                .forEach(option -> System.out.println(option.prettyName+" -> "+option.getOptionNumber()));
    }

    public static Optional<UserOption> findBy(int optionNumber){
        return Arrays.stream(UserOption.values())
                .filter(userOption -> userOption.getOptionNumber()== optionNumber)
                .findAny();
    }
}
