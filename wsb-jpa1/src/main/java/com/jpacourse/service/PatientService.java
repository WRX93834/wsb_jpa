package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

public interface PatientService {
    PatientTO createPatient(PatientTO patientTO);
    PatientTO getPatientById(Long id);
    void deletePatient(Long id);
}
