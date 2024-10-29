package com.keyin.bloodbank_api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "p_name", nullable = false)
    private String name;

    @Column(name = "p_address")
    private String address;

    @Column(name = "p_dob")
    private LocalDate dob;

    @Column(name = "p_phone")
    private String phone;

    @Column(name = "p_gender")
    private String gender;

    @Column(name = "p_bloodType")
    private String bloodType;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donation> donations;

    // Parameterized constructor
    public Person( String name, String address, LocalDate dob, String phone, String gender, String bloodType) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.bloodType = bloodType;
    }

    public Person() {
//    no argument constructor
    };

    // get and set
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public List<Donation> getDonations() {
        return donations;
    }
    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}