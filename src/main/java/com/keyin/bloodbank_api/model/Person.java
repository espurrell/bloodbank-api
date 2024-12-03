package com.keyin.bloodbank_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;



@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int p_id;

    @Column(name = "p_name", nullable = false)
    private String p_name;

    @Column(name = "p_address")
    private String p_address;

    @Column(name = "p_dob")
    private LocalDate p_dob;

    @Column(name = "p_phone")
    private String p_phone;

    @Column(name = "p_gender")
    private String p_gender;

    @Column(name = "p_bloodType")
    private String p_bloodtype;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donation> donations;

    // Parameterized constructor
    public Person(int p_id, String name, String address, LocalDate dob, String phone, String gender, String bloodType) {
        this.p_name = name;
        this.p_address = address;
        this.p_dob = dob;
        this.p_phone = phone;
        this.p_gender = gender;
        this.p_bloodtype = bloodType;
    }

    public Person() {
//    no argument constructor
    };

    // get and set
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

    public LocalDate getDob() {
        return p_dob;
    }
    public void setDob(LocalDate p_dob) {
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

    public String getBloodType() {
        return p_bloodtype;
    }
    public void setBloodType(String p_bloodtype) {
        this.p_bloodtype = p_bloodtype;
    }

    public List<Donation> getDonations() {
        return donations;
    }
    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}