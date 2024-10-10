package za.co.standardbank.controller;

import za.co.standardbank.model.Product;
import za.co.standardbank.service.product.ProductService;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    private ProductController productController;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = Mockito.mock(ProductService.class);
        productController = new ProductController();
        productController.productService = productService; // Injecting the mock
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Product A", 10.0));
        products.add(new Product("2", "Product B", 15.0));

        when(productService.findAllProduct()).thenReturn(products);

        List<Product> result = productController.getAllProducts();
        assertEquals(2, result.size());
        verify(productService).findAllProduct();
    }

    @Test
    public void testGetProductById() {
        Product product = new Product("1", "Product A", 10.0);
        when(productService.findById("1")).thenReturn(product);

        Product result = productController.getProductById("1");
        assertNotNull(result);
        assertEquals("Product A", result.getName());
        verify(productService).findById("1");
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product(null, "Product A", 10.0);

        Response response = productController.createProduct(product);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        verify(productService).createProduct(product);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product(null, "Product A", 10.0);
        product.setId("1");

        Response response = productController.updateProduct("1", product);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
        verify(productService).updateProduct(product);
    }

    @Test
    public void testDeleteProduct() {
        Response response = productController.deleteProduct("1");
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
        verify(productService).deleteProduct("1");
    }
}
