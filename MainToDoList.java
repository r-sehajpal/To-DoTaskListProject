import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import java.util.Iterator;
public class MainToDoList {
    public static void main(String args[]){
        MongoClient mongo = MongoClients.create();

        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "toDoTask",
                "password".toCharArray());

        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("toDoTask");
        System.out.println("Credentials ::"+ credential);
        MongoCollection<Document> myCollection = database.getCollection("taskLists");
        FindIterable<Document> iterDoc = myCollection.find();
        Iterator it = iterDoc.iterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }
}
