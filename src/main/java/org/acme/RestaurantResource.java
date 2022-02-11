package org.acme;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Restaurant")
public class RestaurantResource {

    @Inject
    RestaurantService restaurantService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Restaurant findRestaurantById(@PathParam("id") long id) {
        return restaurantService.findRestaurantById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Restaurant> restaurantWithquery() {
        return (List<Restaurant>) restaurantService.getRestaurant();
    }
}

