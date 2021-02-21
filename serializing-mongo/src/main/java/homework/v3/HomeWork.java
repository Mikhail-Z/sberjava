package homework.v3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import homework.v3.entity.JsonFileClass;
import homework.v3.entity.JsonParameters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class HomeWork {

    private static String inJsonFilename = "parameters.v1.json";

    private static <T extends Serializable> T readJson(String filename, Class<T> clazz) throws IOException {
        org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();
        return mapper.readValue(new File(filename), clazz);
    }

    public static void main(String[] args) throws Exception {
        insert();
    }

    private static MongoCollection<Document> getCollection(MongoClient mongoClient, String databaseName, String collectionName) {
        MongoDatabase sampleTrainingDB = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> parametersCollection = null;
        for (String currentCollectionName : sampleTrainingDB.listCollectionNames()) {
            if (currentCollectionName.equals(collectionName)) {
                parametersCollection = sampleTrainingDB.getCollection(collectionName);
                break;
            }
        }

        if (parametersCollection == null) {
            sampleTrainingDB.createCollection(collectionName);
            parametersCollection = sampleTrainingDB.getCollection(collectionName);
        }

        return parametersCollection;
    }

    private static void insert() throws IOException {
        JsonFileClass jsonFileClass = readJson(inJsonFilename, JsonFileClass.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(jsonFileClass, Map.class);

        String connString = "mongodb://admin:12345@127.0.0.1:27017/parameters";
        try (MongoClient mongoClient = MongoClients.create(connString)) {
            MongoCollection<Document> collection = getCollection(mongoClient, "parameters", "parameters");
            if (map.get("parameters") instanceof ArrayList) {
                ArrayList list1 = (ArrayList) map.get("parameters");
                for (Object o : list1) {
                    LinkedHashMap parameterMap = (LinkedHashMap) o;
                    String name = (String) parameterMap.get("name");
                    collection.insertOne(new Document(name, parameterMap));
                }
            }
        }
    }

    /*private static void delete() throws IOException {
        JsonFileClass jsonFileClass = readJson(inJsonFilename, JsonFileClass.class);

        String nameForDelete = jsonFileClass.getParameters().get(0).getName();
        String connString = "mongodb://admin:12345@127.0.0.1:27017/parameters";
        try (MongoClient mongoClient = MongoClients.create(connString)) {
            MongoCollection<Document> collection = getCollection(mongoClient, "parameters", "parameters");
            FindIterable<Document> result = collection.find(eq("name", nameForDelete));
            System.out.println(result);
        }
    }*/


    private static void update() {

    }

    private static void select() {

    }
}