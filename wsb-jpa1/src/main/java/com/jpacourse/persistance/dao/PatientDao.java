package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long> {
    /**
     * Dodaje wizytę do pacjenta.
     * @param patientId ID pacjenta
     * @param doctorId ID doktora
     * @param time Data i czas wizyty
     * @param description Opis wizyty
     * @return Zaktualizowany pacjent
     */
    PatientEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);
}
