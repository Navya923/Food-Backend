package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class CartRepository implements PanacheRepository<Cart> {


    public Cart postCart(Cart cart) {
        persist(cart);
        return cart;
    }

    @Transactional
    public Cart findCartById(long id) {
        return findById(id);
    }

    String findAndDelete(long id) {
        Cart cart = findById(id);
        if (isPersistent(cart)) {
            if (deleteById(id)) {
                return "Item is deleted with id" + id;
            }
        }
        return "Item is not deleted with id";
    }
}

