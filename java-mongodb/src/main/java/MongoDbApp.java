import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MongoDbApp {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://rootuser:rootpass@localhost:27017"));
        DB database = mongoClient.getDB("company_db");
        DBCollection collection = database.getCollection("test");

        List<Person> people = Arrays.asList(
                new Person("Houari", 24, true, 120d),
                new Person("mohamed", 12, true, 170.5),
                new Person("aicha", 29, false, 125.75)
        );


        people.stream().map(MongoDbApp::personToDBObject)
                .forEach(collection::insert);


        DBCursor cursor = collection.find(personToDBObject(people.get(0)));
        System.out.println(cursor.one());
    }

    private static DBObject personToDBObject(Person person) {
        return new BasicDBObject().append("name", person.name())
                .append("age", person.age())
                .append("sex", person.sex())
                .append("salary", person.salary());
    }
}