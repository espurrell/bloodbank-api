// src/main/java/com/example/bloodbank/model/Donation.java

package com.keyin.bloodbank_api.model;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int d_id;  // Primary Key
    private LocalDate d_date;
    private LocalTime d_time;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    private Person person;

    public Donation(LocalDate Date, LocalTime Time, Person person, int quantity) {
        this.d_date = Date;
        this.d_time = Time;
        this.person = person;
        this.quantity = quantity;
    }

    public Donation() {
        // No-argument constructor
    }

    // Getters and Setters
    public int getId() {
        return d_id;
    }

    public void setId(int Id) {
        this.d_id = Id;
    }

    public LocalDate getDate() {
        return d_date;
    }

    public void setDate(LocalDate dDate) {
        this.d_date = dDate;
    }

    public LocalTime getTime() {
        return d_time;
    }

    public void setTime(LocalTime Time) {
        this.d_time = Time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
