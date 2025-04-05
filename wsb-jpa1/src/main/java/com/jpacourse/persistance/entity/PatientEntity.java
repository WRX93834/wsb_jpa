package com.jpacourse.persistance.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String patientNumber;

	private LocalDate dateOfBirth;

	// ============ RELACJE ============

	// Dwustronna relacja (rodzic) – Patient ma listę wizyt
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	// Komentarz: Relacja dwustronna od strony rodzica (Patient).
	// "VisitEntity" przechowuje klucz obcy patient_id, stąd mappedBy="patient".
	private List<VisitEntity> visits = new ArrayList<>();

	// Jednostronna relacja (dziecko) – Patient posiada Address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	// Komentarz: Relacja jednostronna od strony dziecka (Patient) – w tabeli "patient" jest klucz obcy "address_id".
	private AddressEntity address;

	// ============ GETTERY I SETTERY ============

	public Long getId() {
		return id;
	}

	// ... pozostałe get/set
}
