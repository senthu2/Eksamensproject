package com.example.projecteksamen.models;


import javax.persistence.*;

@Entity
@Table(name = "reperation")
public class Reperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reperation_id")
    private Integer id;

    @Column(name = "first_Name")
    private String first_Name;

    @Column(name = "last_Name")
    private String last_Name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_Number")
    private int phone_Number;

    @Column(name = "damage_Location")
    private String damage_Location;

    @Column(name = "description")
    private String description;

    //Empty Construcktor
    public Reperation() {
    }

    public Reperation(Integer id, String first_Name, String last_Name, String address, String email, int phone_Number, String damage_Location, String description) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.address = address;
        this.email = email;
        this.phone_Number = phone_Number;
        this.damage_Location = damage_Location;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getDamage_Location() {
        return damage_Location;
    }

    public void setDamage_Location(String damage_Location) {
        this.damage_Location = damage_Location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

