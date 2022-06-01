package com.ensias.healthcareapp.model;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Fiche {
    private String Medicine;
    private String description;
    private String traitement;
    private String type;
    private Date dateCreated;
    private String doctor;

    public Fiche(){

    }

    public Fiche(String medicine, String description, String traitement, String type, String doctor ){
        this.Medicine = medicine;
        this.description = description;
        this.traitement = traitement;
        this.type = type;
        this.doctor = doctor;

    }

    public String getMedicine() {
        return Medicine;
    }

    public void setMedicine(String medicine) {
        this.Medicine = medicine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ServerTimestamp
    public Date getDateCreated() { return dateCreated; }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}

