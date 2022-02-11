package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductServiceimpl implements ProductService {

    @Inject
    org.acme.ProductRepository ProductRepository;


    public ProductServiceimpl() {

    }
    @Transactional
    public List<Product> getProductItems() {
        return Product.listAll();
    }

    @Transactional
    public Product findProductById(long id) {
        return ProductRepository.findProductById(id);
    }

    @Override
    public String postProduct(List<Product> productItems) {
        for (Product product : productItems) {
            product.persist();
        }
        return "Items successfully added to cart";
    }


    @Transactional
    public Product updateProduct(long id, Product product) {
        return ProductRepository.updateProduct(id, product);
    }


    public Product postProduct(Product product) {
        product.persist();
        return product;
    }

    @Transactional
    public String deleteProduct(long id) {
        return ProductRepository.findAndDelete(id);
    }
}