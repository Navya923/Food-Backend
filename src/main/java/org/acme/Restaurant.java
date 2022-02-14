package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    private String name;

}


