package com.keyin.bloodbank_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int p_id;
    private String p_name;
    private String p_address;
    private LocalDate p_dob;
    private String p_phone;
    private String p_gender;
    private String p_bloodtype;  // field name

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donation> donations;

    // getters and setters

    public String getBloodType() {
        return p_bloodtype;  // getter method
    }

    public void setBloodType(String p_bloodtype) {
        this.p_bloodtype = p_bloodtype;  // setter method
    }

    public int getId() {
        return p_id;
    }
    public void setId(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return p_name;
    }
    public void setName(String p_name) {
        this.p_name = p_name;
    }

    public String getAddress() {
        return p_address;
    }
    public void setAddress(String p_address) {
        this.p_address = p_address;
    }

    public LocalDate getDOB() {
        return p_dob;
    }
    public void setDOB(LocalDate p_address) {
        this.p_dob = p_dob;
    }

    public String getPhone() {
        return p_phone;
    }
    public void setPhone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getGender() {
        return p_gender;
    }
    public void setGender(String p_gender) {
        this.p_gender = p_gender;
    }
}