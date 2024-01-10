package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.exceptions;

public class PatientDoesNotExistException extends RuntimeException{
    public PatientDoesNotExistException(String mssg){
        super(mssg);
    }
}
