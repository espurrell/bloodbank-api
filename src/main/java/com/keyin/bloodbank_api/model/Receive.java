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
    private int rId;

    // Date the blood was received
    @Column(name = "r_date", nullable = false)
    private Date rDate;

    // Foreign key linking to the Person entity
    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Person person;

    // Quantity of blood received
    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Hospital where blood was received
    @Column(name = "r_hospital", nullable = false)
    private String rHospital;

    // Constructors
    public Receive(LocalDate now, int i, String generalHospital, Person person) {}

    public Receive(Date rDate, Person person, int quantity, String rHospital) {
        this.rDate = rDate;
        this.person = person;
        this.quantity = quantity;
        this.rHospital = rHospital;
    }

    // Getters and Setters

    public int getRId() {
        return rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public Date getRDate() {
        return rDate;
    }

    public void setRDate(Date rDate) {
        this.rDate = rDate;
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
        return rHospital;
    }

    public void setRHospital(String rHospital) {
        this.rHospital = rHospital;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Receive{" +
                "rId=" + rId +
                ", rDate=" + rDate +
                ", person=" + person +
                ", quantity=" + quantity +
                ", rHospital='" + rHospital + '\'' +
                '}';
    }

}
