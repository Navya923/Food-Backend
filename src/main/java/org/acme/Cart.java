package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart extends PanacheEntity {

    private Integer Id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<Product> productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}