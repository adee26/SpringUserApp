package com.myspringproject.SpringUserAppCopy.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Country name is mandatory!")
    private String name;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "country") //deletes all users of a country, if the country is deleted
    private Set<User> users;


    public Country() {
    }

    public Country(long id, @NotBlank(message = "Country name is mandatory!") String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
