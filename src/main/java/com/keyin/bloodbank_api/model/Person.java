package com.keyin.bloodbank_api.model;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_bloodType")
    private String bloodType;

    public void setName(String name) {

    }
}