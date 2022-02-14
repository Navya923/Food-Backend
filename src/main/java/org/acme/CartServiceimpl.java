package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CartServiceimpl implements CartService {

    @Inject
    CartRepository CartRepository;


    public CartServiceimpl() {

    }
    @Transactional
    public List<Cart> getCartItems() {
        return Cart.listAll();
    }

    @Transactional
    public Cart findCartById(long id) {
        return CartRepository.findCartById(id);
    }

    @Override
    public String postCart(List<Cart> cartItems) {
        for (Cart cart : cartItems) {
            cart.persist();
        }
        return "Items successfully added to cart";
    }


//    @Transactional
//    public Cart updateCart(long id, Cart cart) {
//        return CartRepository.updateCart(id, cart);
//    }


    public Cart postCart(Cart cart) {
        cart.persist();
        return cart;
    }

    @Transactional
    public String deleteCart(long id) {
        return CartRepository.findAndDelete(id);
    }
}