package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.stream.Collectors;

public final class PatientMapper {

    private PatientMapper() {}

    public static PatientTO mapToTO(final PatientEntity entity) {
        if (entity == null) {
            return null;
        }
        PatientTO patientTO = new PatientTO();
        patientTO.setId(entity.getId());
        patientTO.setFirstName(entity.getFirstName());
        patientTO.setLastName(entity.getLastName());
        patientTO.setTelephoneNumber(entity.getTelephoneNumber());
        patientTO.setEmail(entity.getEmail());
        patientTO.setPatientNumber(entity.getPatientNumber());
        patientTO.setDateOfBirth(entity.getDateOfBirth());

        if (entity.getVisits() != null) {
            patientTO.setVisits(entity.getVisits().stream()
                    .map(PatientMapper::mapVisitToTO)
                    .collect(Collectors.toList()));
        }
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity entity = new PatientEntity();
        entity.setId(patientTO.getId());
        entity.setFirstName(patientTO.getFirstName());
        entity.setLastName(patientTO.getLastName());
        entity.setTelephoneNumber(patientTO.getTelephoneNumber());
        entity.setEmail(patientTO.getEmail());
        entity.setPatientNumber(patientTO.getPatientNumber());
        entity.setDateOfBirth(patientTO.getDateOfBirth());
        // Mapowanie wizyt pozostawiamy na później (np. przy aktualizacji)
        return entity;
    }

    private static VisitTO mapVisitToTO(final VisitEntity visit) {
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visit.getId());
        visitTO.setTime(visit.getTime());
        visitTO.setDescription(visit.getDescription());

        if (visit.getDoctor() != null) {
            visitTO.setDoctorFirstName(visit.getDoctor().getFirstName());
            visitTO.setDoctorLastName(visit.getDoctor().getLastName());
        }
        if (visit.getMedicalTreatments() != null) {
            visitTO.setTreatmentTypes(visit.getMedicalTreatments().stream()
                    .map(mt -> mt.getType()) // zakładamy, że pole type jest typu String; w razie potrzeby konwersja z enuma
                    .collect(Collectors.toList()));
        }
        return visitTO;
    }
}
