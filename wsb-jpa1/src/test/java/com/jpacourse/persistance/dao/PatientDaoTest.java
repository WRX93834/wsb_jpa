package com.jpacourse.persistance.dao;

import com.jpacourse.WsbJpaApplication;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testAddVisitToPatient() {
        // Tworzymy obiekt AddressEntity
        AddressEntity address = new AddressEntity();
        address.setCity("Warszawa");
        address.setAddressLine1("ul. Testowa 1");
        address.setPostalCode("00-001");

        // Tworzymy pacjenta i przypisujemy adres
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jan");
        patient.setLastName("Kowalski");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("jan.kowalski@example.com");
        patient.setPatientNumber("P001");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setAddress(address); // Kluczowe – przypisanie adresu

        // Zapisujemy pacjenta; dzięki cascade, adres również zostanie zapisany
        PatientEntity savedPatient = patientDao.save(patient);
        assertNotNull(savedPatient.getId());

        // Tworzymy i zapisujemy doktora, który będzie potrzebny przy tworzeniu wizyty
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Adam");
        doctor.setLastName("Mickiewicz");
        doctor.setTelephoneNumber("111222333");
        doctor.setEmail("adam@example.com");
        doctor.setDoctorNumber("D001");
        doctor.setSpecialization("GP");
        entityManager.persist(doctor);
        Long doctorId = doctor.getId();
        assertNotNull(doctorId);

        // Definiujemy dane wizyty
        LocalDateTime visitTime = LocalDateTime.now();
        String description = "Testowa wizyta";

        // Wywołujemy metodę dodającą wizytę do pacjenta
        PatientEntity updatedPatient = patientDao.addVisitToPatient(savedPatient.getId(), doctorId, visitTime, description);

        assertNotNull(updatedPatient);
        assertFalse(updatedPatient.getVisits().isEmpty());
        assertEquals(1, updatedPatient.getVisits().size());
        assertEquals(description, updatedPatient.getVisits().get(0).getDescription());
    }
}
