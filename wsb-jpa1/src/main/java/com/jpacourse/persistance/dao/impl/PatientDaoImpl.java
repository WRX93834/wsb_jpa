package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    @Transactional
    public PatientEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {
        PatientEntity patient = findOne(patientId);
        if (patient == null) {
            throw new RuntimeException("Patient not found with id: " + patientId);
        }
        // Pobieramy doktora – zakładamy, że encja DoctorEntity działa analogicznie do reszty
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        if (doctor == null) {
            throw new RuntimeException("Doctor not found with id: " + doctorId);
        }
        VisitEntity visit = new VisitEntity();
        visit.setTime(time);
        visit.setDescription(description);
        visit.setPatient(patient);
        visit.setDoctor(doctor);

        patient.getVisits().add(visit);
        // Kaskadowy update pacjenta
        return update(patient);
    }
}
