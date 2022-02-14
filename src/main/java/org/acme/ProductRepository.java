package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;


@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public List<Product> findByRestaurant(long restaurantId) {
        return list("restaurantId", restaurantId);
    }

    public Product updateProduct(long id, Product product) {
        Product entity = findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setQuantity(product.getQuantity());

        persist(entity);
        return entity;
    }

    public Product addProduct(Product product) {
        persist(product);
        return product;
    }

    @Transactional
    public Product findProductById(long id) {
        return findById(id);
    }

    @Transactional
    public List<Product> findProductByrestaurantId(long restaurantId) {
        return list("restaurantId", restaurantId);
    }

    String findAndDelete(long id) {
        Product product = findById(id);
        if (isPersistent(product)) {
            if (deleteById(id)) {
                return "Item is deleted with id" + id;
            }
        }
        return "Item is not deleted with id";
    }
}