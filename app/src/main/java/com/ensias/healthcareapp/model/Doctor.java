package com.ensias.healthcareapp.model;

public class Doctor {
    private String name;

    private String tel;
    private String email;
    private String specialite;

    public Doctor(){
        //needed for firebase
    }

    public Doctor(String name ,String tel, String email, String specialite) {
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.specialite = specialite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
