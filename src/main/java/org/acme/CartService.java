package org.acme;

import java.util.List;


public interface CartService {

    Cart findCartById(long id);

    String postCart(List<Cart> cartItems);

    Cart updateCart(long id, Cart cart);

    String deleteCart(long id);

    List<Cart> getCartItems();

}