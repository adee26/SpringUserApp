package com.myspringproject.SpringUserAppCopy.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory.")
    private String name;
    @NotBlank(message = "Email is mandatory.")
    private String email;
//    @NotBlank(message = "Country is mandatory.")
//    private Country country;
    @ManyToOne
    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    public User() {
    }

    public User(long id, String name, String email, Country country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
