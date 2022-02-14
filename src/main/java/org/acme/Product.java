package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Product  {

    @Id
    @GeneratedValue
    private Long id;

    private String quantity;

    private String price;

    private String name;

    private String discount;

    public Product(Long id, String quantity, String price, String name, String discount, String URL, long restaurantId, String category, String topPick, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.discount = discount;
        this.URL = URL;
        this.restaurantId = restaurantId;
        this.category = category;
        this.topPick = topPick;
        this.cart = cart;
    }

    public Product() {
    }

    private String URL;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopPick() {
        return topPick;
    }

    public void setTopPick(String topPick) {
        this.topPick = topPick;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private long restaurantId;

    private String category;

    private String topPick;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
