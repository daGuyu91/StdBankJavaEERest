package za.co.standardbank.service.product;

import za.co.standardbank.model.Product;
import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> findAllProduct();

    Product findById(String id);

    void updateProduct(Product product);

    void deleteProduct(String id);
}
