package com.jpacourse.persistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String addressLine1;

	private String addressLine2;

	@Column(nullable = false)
	private String postalCode;

	// Brak relacji zwrotnej do Patient (jednostronna relacja w PatientEntity)

	// ============ GETTERY I SETTERY ============

	public Long getId() {
		return id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	// ... pozostałe get/set
}
