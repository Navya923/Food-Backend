package org.acme;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Product")
public class ProductResource {


    @Inject
    ProductService productService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String addItemstoProduct(List<Product> productItems) {
        return productService.postProduct(productItems);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Product updateProduct(@PathParam("id") long id, Product product) {
        return productService.updateProduct(id, product);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Product findProductById(@PathParam("id") long id, Product product) {
        return productService.findProductById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Product> productWithquery() {
        return (List<Product>) productService.getProductItems();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProduct(@PathParam("id") long id) {
        return productService.deleteProduct(id);
    }
}
