// src/main/java/com/example/bloodbank/model/Donation.java

package com.keyin.bloodbank_api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;  // Primary Key

    private LocalDate Date;
    private LocalTime Time;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    private Person person;

    public Donation(LocalDate now, LocalTime of, Person person1, int i) {
    }

    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate dDate) {
        this.Date = dDate;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime Time) {
        this.Time = Time;
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
