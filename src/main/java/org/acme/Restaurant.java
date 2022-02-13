package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Restaurant extends PanacheEntity {
    @Column
    private String name;
//    @Column
//    private String logo;
//    @Column
//    private String address;

}


