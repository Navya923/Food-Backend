package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RestaurantRepository implements PanacheRepository<Restaurant> {

    public Restaurant findRestaurantById(long id) {
        return findById(id);
    }
}

