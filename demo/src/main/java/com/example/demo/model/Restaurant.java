package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name = "restaurant")
public class Restaurant {
    private int id;
    private String Name;
    private String City;
    private String TEL;

    public Restaurant(){
    }

    public Restaurant(int id, String Name, String City, String TEL) {
        this.id = id;
        this.Name=Name;
        this.City = City;
        this.TEL = TEL;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }
}
