package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Product extends PanacheEntity {

    @Column
    String quantity;
    @Column
    String price;
    @Column
    String name;
    @Column
    private String discount;
    @Column
    private String URL;
    @Column
    private long restaurantId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Cart getCart(){
        return cart;
    }
}
