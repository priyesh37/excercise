package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.request;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.enums.VaccinationPrefrence;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PatientSignupDTO {
    String name;
    String email;
    String password;
    String aadharNumber;
    long phoneNumber;
    String gender;
    VaccinationPrefrence vaccinationPrefrence; // Sputnik, Covaxin, Covishield, xyz
    String address;
}
