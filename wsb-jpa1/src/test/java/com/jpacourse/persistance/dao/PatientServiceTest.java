package com.jpacourse.persistance.dao;

import com.jpacourse.WsbJpaApplication;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testCreateAndGetPatient_withoutAddress_shouldFail() {
        // Przygotowujemy obiekt transferowy pacjenta bez adresu
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Maria");
        patientTO.setLastName("Nowak");
        patientTO.setTelephoneNumber("987654321");
        patientTO.setEmail("maria.nowak@example.com");
        patientTO.setPatientNumber("P002");
        patientTO.setDateOfBirth(LocalDate.of(1990, 5, 20));
        // Nie ustawiamy adresu – co powinno wywołać błąd, bo encja wymaga nie-nullowego adresu

        Exception ex = assertThrows(RuntimeException.class, () -> {
            patientService.createPatient(patientTO);
        });
        assertTrue(ex.getMessage().contains("ADDRESS_ID"));
    }
}
