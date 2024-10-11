package za.co.standardbank.config;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConfig {
    // Update with your MongoDB username and password
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String CONNECTION_STRING = String.format(
            "mongodb://%s:%s@mongodb:27017",
            USERNAME,
            PASSWORD
    );
    private static final String DATABASE_NAME = "myDatabase";

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }
}
