package com.keyin.bloodbank_api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Receive")
public class Receive {

    // Primary key for the Receive entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private int r_id;

    // Date the blood was received
    @Column(name = "r_date", nullable = false)
    private Date r_date;

    // Foreign key linking to the Person entity
    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Person person;

    // Quantity of blood received
    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Hospital where blood was received
    @Column(name = "r_hospital", nullable = false)
    private String r_hospital;

    // Constructors
    public Receive(LocalDate now, int i, String generalHospital, Person person) {}

    public Receive(Date r_date, Person person, int quantity, String r_hospital) {
        this.r_date = r_date;
        this.person = person;
        this.quantity = quantity;
        this.r_hospital = r_hospital;
    }

    // Getters and Setters

    public int getRId() {
        return r_id;
    }

    public void setRId(int r_id) {
        this.r_id = r_id;
    }

    public Date getRDate() {
        return r_date;
    }

    public void setRDate(Date r_date) {
        this.r_date = r_date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRHospital() {
        return r_hospital;
    }

    public void setRHospital(String r_hospital) {
        this.r_hospital = r_hospital;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Receive{" +
                "r_id=" + r_id +
                ", r_date=" + r_date +
                ", person=" + person +
                ", quantity=" + quantity +
                ", r_hospital='" + r_hospital + '\'' +
                '}';
    }

}
