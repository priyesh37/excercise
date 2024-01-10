package com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.dto.request;

import com.covivaccination.distributionsystem.Covid.Vaccination.Distribution.Backend.enums.VaccinationCenterPrefrence;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateAppointmentDTO {
    UUID id;
    VaccinationCenterPrefrence vaccinationCenterPrefrence;
}
