package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RestaurantServiceimpl implements RestaurantService {

    @Inject
    RestaurantRepository RestaurantRepository;

    public RestaurantServiceimpl() {
    }

    @Transactional
    public List<Restaurant> getRestaurant() {
        return Restaurant.listAll();
    }

    @Transactional
    public Restaurant findRestaurantById(long id) {
        return RestaurantRepository.findRestaurantById(id);
    }

}

