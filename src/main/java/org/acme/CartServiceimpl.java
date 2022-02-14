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
        return Cart.listAll();
    }

    @Transactional
    public Cart findCartById(long id) {
        return cartRepository.findCartById(id);
    }

    @Override
    public String postCart(List<Cart> cartItems) {
        return null;
    }


//    @Override
//    public String postCart(List<Cart> cartItems) {
//        for (Cart cart : cartItems) {
//            cart.persist();
//        }
//        return "Items successfully added to cart";
//    }

    /**
     * Cart cart = cartrepo.find().firstResult();
     * 2. if cart == null
     *     cart = new Cart();
     *     cart.persist();
     *     cart.id save in product and change quantity to 1
     *     if cart != null
     *     cart.id save in product and change quantity to 1
     * @param cart
     * @return
     */

    public Cart postCart(Cart cart) {
        Cart cart1 = cartRepository.findAll().firstResult();
        if (cart1 == null) {
            cart.persist();

        }
        else {
            List<Product> cartItems = cart1.getProducts();
            Product product = cart.getProducts() .get(0);
            cartItems.add(product);
            cart1.setProducts(cartItems);
            cart1.persist();

        }
        return cart1;
    }


    @Transactional
    public String deleteCart(long id) {
        return cartRepository.findAndDelete(id);
    }
}