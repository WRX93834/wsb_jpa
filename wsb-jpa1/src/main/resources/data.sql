-- Insert doktorów
INSERT INTO doctor (first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    ('Adam', 'Mickiewicz', '111222333', 'adam@example.com', 'D001', 'GP'),
    ('Ewa', 'Nowak', '222333444', 'ewa.nowak@example.com', 'D002', 'SURGEON'),
    ('Jan', 'Kowalski', '333444555', 'jan.kowalski@example.com', 'D003', 'DERMATOLOGIST'),
    ('Anna', 'Zielińska', '444555666', 'anna.zielinska@example.com', 'D004', 'OCULIST');

-- Insert adresów
INSERT INTO address (city, address_line1, postal_code)
VALUES
    ('Warszawa', 'ul. Testowa 1', '00-001'),
    ('Kraków', 'ul. Królewska 10', '30-001'),
    ('Gdańsk', 'ul. Morska 5', '80-001'),
    ('Wrocław', 'ul. Piękna 2', '50-001');

-- Insert pacjentów (przyjmujemy, że identyfikatory adresów to 1,2,3,4)
INSERT INTO patient (first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES
    ('Maria', 'Skłodowska', '444555666', 'maria@example.com', 'P004', '1995-03-15', 1),
    ('Piotr', 'Nowak', '555666777', 'piotr.nowak@example.com', 'P005', '1985-07-20', 2),
    ('Katarzyna', 'Kowalska', '666777888', 'katarzyna.kowalska@example.com', 'P006', '1978-11-30', 3),
    ('Tomasz', 'Zieliński', '777888999', 'tomasz.zielinski@example.com', 'P007', '1990-03-05', 4);

-- Insert wizyt (zakładamy, że ID doktorów: 1-4 oraz pacjentów: 1-4)
INSERT INTO visit (description, time, doctor_id, patient_id)
VALUES
    ('Konsultacja', CURRENT_TIMESTAMP, 1, 1),
    ('Kontrola stanu zdrowia', CURRENT_TIMESTAMP, 2, 2),
    ('Badanie dermatologiczne', CURRENT_TIMESTAMP, 3, 3),
    ('Wizyta okulistyczna', CURRENT_TIMESTAMP, 4, 4),
    ('Szybka konsultacja', CURRENT_TIMESTAMP, 1, 2);

-- Opcjonalnie: Insert zabiegów (medical_treatment)
INSERT INTO medical_treatment (visit_id, description, type)
VALUES
    (1, 'USG jamy brzusznej', 'USG'),
    (2, 'EKG spoczynkowe', 'EKG'),
    (3, 'RTG klatki piersiowej', 'RTG'),
    (4, 'Badanie wzroku', 'RTG'),
    (5, 'USG tarczycy', 'USG');
