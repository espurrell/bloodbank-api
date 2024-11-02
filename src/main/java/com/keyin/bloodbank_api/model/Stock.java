package com.keyin.bloodbank_api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    private String s_bloodtype;  // Primary Key
    private int quantity;

    public Stock() {
    }

    // Getters and Setters
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

