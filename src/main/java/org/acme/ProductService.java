
package org.acme;

import java.util.List;


public interface ProductService {

    Product findProductById(long id);

    String postProduct(List<Product> productItems);

    Product updateProduct(long id, Product product);

    String deleteProduct(long id);

    List<Product> getProductItems();

}