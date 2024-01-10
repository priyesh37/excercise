package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.response;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Doctor;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.Patient;
import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.models.VaccinationCenter;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentDTO {
    int doseNumber;
    Patient patient;
    UUID docID;
    String docName;
    UUID vcID;
    String vaccinationCenterName;
}
