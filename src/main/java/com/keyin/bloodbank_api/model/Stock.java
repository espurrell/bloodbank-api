package com.keyin.bloodbank_api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    private String Bloodtype;  // Primary Key
    private int quantity;

    // Getters and Setters
    public String getsBloodtype() {
        return Bloodtype;
    }

    public void setsBloodtype(String sBloodtype) {
        this.Bloodtype = sBloodtype;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

