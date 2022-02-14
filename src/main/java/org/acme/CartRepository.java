package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class CartRepository implements PanacheRepository<Cart> {
    public static Cart addCart(CartService cartService) {
        Cart entity = new Cart();
        return entity;
    }

//
//    public <quantity, and, in> Cart updateCart(long id, Cart cart) {
//        Cart entity = Cart.findById(id);
////        if (entity == null) {
////            throw new NotFoundException();
////        }
//////        entity.quantity = cart.quantity;
////        entity.persist();
////        return entity;
////    }
//        if (cart == null) {
//            cart = new cart();
//            cart.persist();
////            cart.id save in product and change quantity to 1;
////            if (cart != null) {
////                cart.id save in product and change quantity to 1;
////            }
//        }
//    @Transactional
//    public Cart updateCart(long id, Cart cart) {
//        Cart byId = Cart.findById(id);
//        byId.setCart(cart);
//        byId.persist();
//        return byId;
//    }
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

//package org.acme;
//
//import io.quarkus.hibernate.orm.panache.PanacheRepository;
//
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@ApplicationScoped
//public class CartRepository implements PanacheRepository<Cart> {
//
//    @Inject
//    EntityName en;
//    private Quantity quantity;
////
//    @Transactional
//    public Cart addCart(CartItems resource)
//    {
//        Cart cart = new Cart();
//        cart.setCart(resource.getCart());
//        Cart.setCart(resource.getCart());
//        Cart.setName(resource.getId());
//        cart.setCartItems(payload.getCartItems());
//        cart.setStatus(Cart.NEW);
////    candidate.setStatus(Status.HR_APPROVAL);
//        cart.persist();
//        return cart;
//
//    }
//    @Transactional
//    public List<Cart> getCart(Cart cart)
//    {
//
//
//        TypedQuery<Cart> q =
//                en.createQuery("select t from Cart t where t.cart = :cart", Cart.class);
//
//        q.setParameter("cart", cart);
//
//        return  q.getResultList();
//
//
//    }
//
//
//
//
//    @Transactional
//    public void updatecart(long id, Cart cart) {
//        Cart byId = Cart.findById(id);
//        byId.setCart(cart);
//        byId.persist();
//    }

