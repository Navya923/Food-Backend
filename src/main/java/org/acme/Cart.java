package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Cart extends PanacheEntity {
    public List<Product> getProducts() {
        return products;
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Cart() {
    }

    public Cart(Long id) {
        this.id = id;
    }
@OneToMany(mappedBy = "cart", fetch=FetchType.EAGER)
   private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}