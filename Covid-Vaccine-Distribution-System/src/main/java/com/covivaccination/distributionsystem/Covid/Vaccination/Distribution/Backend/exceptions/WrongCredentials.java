package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.exceptions;

public class WrongCredentials extends RuntimeException{
    public WrongCredentials(String mssg){
        super(mssg);
    }
}
