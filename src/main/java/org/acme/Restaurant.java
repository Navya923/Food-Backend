package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Restaurant extends PanacheEntity {
    @Column
    public String name;
    @Column
    public String logo;
    @Column
    public String address;

}
