package za.co.standardbank.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import za.co.standardbank.config.MongoDBConfig;
import za.co.standardbank.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository {
    private final MongoDatabase database = MongoDBConfig.getDatabase();
    private final MongoCollection<Document> userCollection = database.getCollection("users");

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (Document doc : userCollection.find()) {
            users.add(User.fromDocument(doc));
        }
        return users;
    }

    public User findById(String id) {
        Document doc = userCollection.find(new Document("id", id)).first();
        return doc != null ? User.fromDocument(doc) : null;
    }

    public void save(User user) {
        userCollection.insertOne(user.toDocument());
    }

    public void update(User user) {
        userCollection.replaceOne(new Document("id", user.getId()), user.toDocument());
    }

    public void delete(String id) {
        userCollection.deleteOne(new Document("id", id));
    }
}

