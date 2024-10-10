package za.co.standardbank.service.product;

import za.co.standardbank.model.Product;
import za.co.standardbank.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.delete(id);
    }
}
