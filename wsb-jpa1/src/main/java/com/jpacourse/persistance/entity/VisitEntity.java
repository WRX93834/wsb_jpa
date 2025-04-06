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

	// Dwustronna relacja (dziecko) – wizyta odnosi się do doktora
	@ManyToOne(optional = false)
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor;

	// Dwustronna relacja (dziecko) – wizyta odnosi się do pacjenta
	@ManyToOne(optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	// Jednostronna relacja (rodzic) – Visit posiada listę zabiegów
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "visit_id", nullable = false)
	private List<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>();

	// Gettery i settery
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public List<MedicalTreatmentEntity> getMedicalTreatments() {
		return medicalTreatments;
	}
	public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
		this.medicalTreatments = medicalTreatments;
	}
}
