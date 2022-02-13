package org.acme;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Cart")
public class CartResource {


    @Inject
    CartService cartService;

    @POST
    @Path("/cart")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String addItemstoCart(List<Cart> cartItems) {
        return cartService.postCart(cartItems);
    }

    @PUT
    @Path("/cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cart updateCart(@PathParam("id") long id, Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @GET
    @Path("/cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cart findCartById(@PathParam("id") long id, Cart cart) {
        return cartService.findCartById(id);
    }


    @GET
    @Path("/cart")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Cart> cartWithquery() {
        return (List<Cart>) cartService.getCartItems();
    }

    @DELETE
    @Path("/cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCart(@PathParam("id") long id) {
        return cartService.deleteCart(id);
    }
}


