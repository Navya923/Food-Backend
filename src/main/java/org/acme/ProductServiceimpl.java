package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductServiceimpl implements ProductService {

    @Inject
    org.acme.ProductRepository productRepository;


    public ProductServiceimpl() {

    }
    @Transactional
    public List<Product> getProductItems() {
        return productRepository.listAll();
    }

    @Override
    public List<Product> findProductByrestaurantId(long restaurantId) {
        return productRepository.findProductByrestaurantId(restaurantId);
    }

    @Transactional
    public Product findProductById(long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public String postProduct(List<Product> productItems) {
        for (Product product : productItems) {
            productRepository.persist(product);
        }
        return "Items successfully added to cart";
    }


    @Transactional
    public Product updateProduct(long id, Product product) {
        return productRepository.updateProduct(id, product);
    }


    public Product postProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    @Transactional
    public String deleteProduct(long id) {
        return productRepository.findAndDelete(id);
    }
}