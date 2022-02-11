package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cart extends PanacheEntity {
    @Column
    public String quantity;
    @OneToMany(mappedBy = "cart")
    public List<Product> productId;
}
