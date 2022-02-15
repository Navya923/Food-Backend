package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CartServiceimpl implements CartService {

    @Inject
    CartRepository cartRepository;

    public CartServiceimpl() {

    }

    @Transactional
    public List<Cart> getCartItems() {
        return cartRepository.listAll();
    }

    @Transactional
    public Cart findCartById(long id) {
        return cartRepository.findCartById(id);
    }

    @Override
    public String postCart(List<Cart> cartItems) {
        return null;
    }

    public Cart postCart(Cart cart) {
        cartRepository.persist(cart);
        return cart;
    }

    @Transactional
    public String deleteCart(long id) {
        return cartRepository.findAndDelete(id);
    }
}