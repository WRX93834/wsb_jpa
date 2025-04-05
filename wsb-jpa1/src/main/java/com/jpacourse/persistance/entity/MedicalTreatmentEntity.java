package com.jpacourse.persistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_treatment")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String type;

	// Brak pola 'visit' – to relacja jednostronna zdefiniowana w VisitEntity

	// ============ GETTERY I SETTERY ============

	public Long getId() {
		return id;
	}

	// ... pozostałe get/set
}
