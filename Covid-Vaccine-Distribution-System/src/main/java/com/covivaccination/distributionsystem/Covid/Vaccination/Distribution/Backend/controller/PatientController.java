package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.controller;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.request.PatientLoginDTO;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.request.PatientSignupDTO;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.response.AppointmentDTO;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.response.GeneralMessageDTO;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.enums.VaccinationCenterPrefrence;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.exceptions.PatientDoesNotExistException;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.exceptions.WrongCredentials;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Patient;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.service.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody PatientSignupDTO patientSignupDTO){
        Patient patient = patientService.signUp(patientSignupDTO);
        return new ResponseEntity(patient, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody PatientLoginDTO patientLoginDTO){
        try{
            Patient patient = patientService.login(patientLoginDTO);
            return new ResponseEntity(patient, HttpStatus.OK);
        }catch (WrongCredentials wrongCredentials){
            return new ResponseEntity(new GeneralMessageDTO(wrongCredentials.getMessage()), HttpStatus.UNAUTHORIZED);
        }catch(PatientDoesNotExistException patientDoesNotExistException){
            return new ResponseEntity(new GeneralMessageDTO(patientDoesNotExistException.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/createappointment")
    public ResponseEntity createAppointment(@RequestParam String email, @RequestParam VaccinationCenterPrefrence vaccinationCenterPrefrence){
        AppointmentDTO appointmentDTO = patientService.createAppointment(email, vaccinationCenterPrefrence.toString());
        return new ResponseEntity(appointmentDTO, HttpStatus.OK);
    }

}
