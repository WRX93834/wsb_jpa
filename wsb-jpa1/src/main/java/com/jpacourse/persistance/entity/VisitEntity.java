package com.jpacourse.persistance.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visit")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// ============ RELACJE ============

	// Dwustronna relacja (dziecko) – wizyta odnosi się do doktora
	@ManyToOne(optional = false)
	@JoinColumn(name = "doctor_id", nullable = false)
	// Komentarz: Relacja dwustronna od strony dziecka (Visit) – klucz obcy w "visit" -> doctor_id.
	private DoctorEntity doctor;

	// Dwustronna relacja (dziecko) – wizyta odnosi się do pacjenta
	@ManyToOne(optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	// Komentarz: Relacja dwustronna od strony dziecka (Visit) – klucz obcy w "visit" -> patient_id.
	private PatientEntity patient;

	// Jednostronna relacja (rodzic) – Visit posiada listę zabiegów
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "visit_id", nullable = false)
	// Komentarz: Relacja jednostronna od strony rodzica (Visit).
	// "MedicalTreatmentEntity" nie posiada pola 'visit', klucz obcy "visit_id" tworzymy przez @JoinColumn.
	private List<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>();

	// ============ GETTERY I SETTERY ============

	public Long getId() {
		return id;
	}

	// ... pozostałe get/set
}
