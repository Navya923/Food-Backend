package org.acme;

import java.util.List;


public interface RestaurantService {

    Restaurant findRestaurantById(long id);

    List<Restaurant> getRestaurant();

}