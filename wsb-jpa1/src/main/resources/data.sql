-- Opcjonalnie: Jeśli nie potrzebujesz tego rekordu, możesz go usunąć
INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES (901, 'xx', 'yy', 'city', '60-400');

-- 1. Wstawianie rekordów do tabeli "address"
-- Adresy muszą istnieć, bo pacjent odwołuje się do adresu
INSERT INTO address (id, city, address_line1, address_line2, postal_code)
VALUES (1, 'Warszawa', 'Ul. Miodowa 1', 'Apt 101', '00-001');

INSERT INTO address (id, city, address_line1, address_line2, postal_code)
VALUES (2, 'Kraków', 'Ul. Krucza 15', NULL, '30-001');

-- 2. Wstawianie rekordów do tabeli "doctor"
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'Jan', 'Nowak', '123456789', 'jan.nowak@example.com', 'D001', 'CARDIOLOGY');

-- 3. Wstawianie rekordów do tabeli "patient"
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES (1, 'Anna', 'Kowalska', '987654321', 'anna.kowalska@example.com', 'P001', '1980-05-10', 1);

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES (2, 'Piotr', 'Zieliński', '1122334455', 'piotr.zielinski@example.com', 'P002', '1975-03-15', 2);

-- 4. Wstawianie rekordów do tabeli "visit"
INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (1, 'Regular checkup', '2025-04-01 10:00:00', 1, 1);

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (2, 'Follow-up visit', '2025-04-02 11:30:00', 1, 2);

-- 5. Wstawianie rekordów do tabeli "medical_treatment"
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Angioplasty procedure', 'SURGERY', 1);

INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (2, 'Routine blood test', 'DIAGNOSTIC', 2);
