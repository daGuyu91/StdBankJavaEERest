package za.co.standardbank.controller;

import za.co.standardbank.model.Product;
import za.co.standardbank.repository.ProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductController {
    private final ProductRepository productRepository = new ProductRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getproductById(@PathParam("id") String id) {
        return productRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createproduct(Product product) {
        productRepository.save(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateproduct(@PathParam("id") String id, Product product) {
        product.setId(id);
        productRepository.update(product);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteproduct(@PathParam("id") String id) {
        productRepository.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

