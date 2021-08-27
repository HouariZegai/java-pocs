import com.mongodb.*;

import java.util.Arrays;
import java.util.List;

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


        // Insert
        people.stream().map(MongoDbApp::personToDBObject)
                .forEach(collection::insert);


        // Read
        DBCursor cursor = collection.find(personToDBObject(people.get(0)));
        System.out.println(cursor.one());

        // Read all data found
        System.out.print("Read all match: ");
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        // Update
        DBObject beforeModifiedObj = collection.findAndModify(personToDBObject(people.get(1)),
                personToDBObject(new Person("test", 1, false, 0d)));
        System.out.println("Before update:" + beforeModifiedObj);

        // Delete
        DBObject removedObj = collection.findAndRemove(personToDBObject(people.get(0)));
        System.out.println("To be removed: " + removedObj);

        mongoClient.close();
    }

    private static DBObject personToDBObject(Person person) {
        return new BasicDBObject().append("name", person.name())
                .append("age", person.age())
                .append("sex", person.sex())
                .append("salary", person.salary());
    }
}