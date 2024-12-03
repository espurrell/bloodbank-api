package com.keyin.bloodbank_api.model;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;  // Primary Key, auto-generated

    private String s_bloodtype;  // Blood type

    private int quantity;  // Quantity of blood in stock

    public Stock() {
        // No-argument constructor
    }

    // Getters and Setters
    public Long getS_Id() {
        return s_id;
    }

    public void setS_Id(Long s_id) {
        this.s_id = s_id;
    }

    public String getBloodType() {
        return s_bloodtype;
    }

    public void setBloodType(String s_bloodtype) {
        this.s_bloodtype = s_bloodtype;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
