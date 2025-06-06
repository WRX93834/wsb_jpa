package com.jpacourse.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable {
    private Long id;
    private LocalDateTime time;
    private String description;
    private String doctorFirstName;
    private String doctorLastName;
    private List<String> treatmentTypes; // reprezentacja typów leczenia

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDoctorFirstName() { return doctorFirstName; }
    public void setDoctorFirstName(String doctorFirstName) { this.doctorFirstName = doctorFirstName; }

    public String getDoctorLastName() { return doctorLastName; }
    public void setDoctorLastName(String doctorLastName) { this.doctorLastName = doctorLastName; }

    public List<String> getTreatmentTypes() { return treatmentTypes; }
    public void setTreatmentTypes(List<String> treatmentTypes) { this.treatmentTypes = treatmentTypes; }
}
