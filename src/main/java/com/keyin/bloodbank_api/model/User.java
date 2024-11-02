package com.keyin.bloodbank_api.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "usr_password", nullable = false)
    private String usr_password;

    // No-argument constructor
    public User() {
    }

    // Constructor with username and password
    public User(String username, String usr_password) {
        this.username = username;
        this.usr_password = usr_password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return usr_password; }
    public void setPassword(String usr_password) { this.usr_password = usr_password; }
}
