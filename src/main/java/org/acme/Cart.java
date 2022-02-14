package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Cart extends PanacheEntity {

    public Cart() {
    }

    public Cart(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}