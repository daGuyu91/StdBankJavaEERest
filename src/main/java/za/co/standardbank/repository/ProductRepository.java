package za.co.standardbank.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import za.co.standardbank.config.MongoDBConfig;
import za.co.standardbank.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final MongoDatabase database = MongoDBConfig.getDatabase();
    private final MongoCollection<Document> productCollection = database.getCollection("products");

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        for (Document doc : productCollection.find()) {
            products.add(Product.fromDocument(doc));
        }
        return products;
    }

    public Product findById(String id) {
        Document doc = productCollection.find(new Document("id", id)).first();
        return doc != null ? Product.fromDocument(doc) : null;
    }

    public void save(Product product) {
        productCollection.insertOne(product.toDocument());
    }

    public void update(Product product) {
        productCollection.replaceOne(new Document("id", product.getId()), product.toDocument());
    }

    public void delete(String id) {
        productCollection.deleteOne(new Document("id", id));
    }
}

