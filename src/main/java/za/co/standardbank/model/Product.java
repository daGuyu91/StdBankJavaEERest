package za.co.standardbank.model;

import org.bson.Document;

public class Product {

    private String id;
    private String name;

    public Product() {
    }

    private Double price;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Document toDocument() {
        return new Document("id", id).append("name", name).append("price", price);
    }

    public static Product fromDocument(Document doc) {
        return new Product(doc.getString("id"), doc.getString("name"), doc.getDouble("price"));
    }

}
