package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends PanacheEntity {
    @Column
    public String quantity;
    @Column
    public String price;
    @Column
    public String title;
    @Column
    public String discount;
    @Column
    public String URL;
    @Column
    public long restaurantId;
    @ManyToOne
    public Cart cart;
}

