package com.sda.petclinic;

import com.sda.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
    //temporary change until we have the repository implementation;
        SessionManager.getSessionFactory().openSession();
    }
}
