package com.keyin.bloodbank_api.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate primary key
    private Long u_id;

    private String username;

    private String usr_password;

    // No-argument constructor
    public User() {
    }

    // Constructor with id, username, and password
    public User(Long u_id, String username, String usr_password) {
        this.u_id = u_id;
        this.username = username;
        this.usr_password = usr_password;
    }

    // Constructor without id (for cases where id is auto-generated)
    public User(String username, String usr_password) {
        this.username = username;
        this.usr_password = usr_password;
    }

    // Getters and setters
    public Long getU_Id() {
        return u_id;
    }

    public void setId(Long u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return usr_password;
    }

    public void setPassword(String usr_password) {
        this.usr_password = usr_password;
    }
}
