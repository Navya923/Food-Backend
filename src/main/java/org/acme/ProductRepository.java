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
        Product entity = Product.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.title = product.title;
        entity.price = product.price;
        entity.quantity = product.quantity;
        entity.persist();
        return entity;
    }

    public Product addProduct(Product product) {
        product.persist();
        return product;
    }

    @Transactional
    public Product findProductById(long id) {
        return findById(id);
    }

    String findAndDelete(long id) {
        Product product = findById(id);
        if (product.isPersistent()) {
            if (deleteById(id)) {
                return "Item is deleted with id" + id;
            }
        }
        return "Item is not deleted with id";
    }
}