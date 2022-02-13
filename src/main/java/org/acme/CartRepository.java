package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;


@ApplicationScoped
public class CartRepository implements PanacheRepository<Cart> {


    public Cart updateCart(long id, Cart cart) {
        Cart entity = Cart.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
//        entity.quantity = cart.quantity;
        entity.persist();
        return entity;
    }


    public Cart postCart(Cart cart) {
        cart.persist();
        return cart;
    }

    @Transactional
    public Cart findCartById(long id) {
        return findById(id);
    }

    String findAndDelete(long id) {
        Cart cart = findById(id);
        if (cart.isPersistent()) {
            if (deleteById(id)) {
                return "Item is deleted with id" + id;
            }
        }
        return "Item is not deleted with id";
    }
}