package JsonReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonReaderTest {
    public static void main(String[] args) {
        try {
            JsonReader reader = Json.createReader(new FileReader("./test.json"));
            JsonObject json = reader.readObject();
            String name = json.getString("name");
            String email = json.getString("email");
            Boolean isActive = json.getBoolean("isActive");
            JsonObject address = json.getJsonObject("address");
            String street = address.getString("street");
            String city = address.getString("city");
            String country = address.getString("country");
            String postalCode = address.getString("postalCode");
            JsonArray orders = json.getJsonArray("orders");
            JsonObject orderOne = orders.getJsonObject(0);
            String orderId = orderOne.getString("orderId");
            double amount = orderOne.getJsonNumber("amount").doubleValue();
            String status = orderOne.getString("status");
            System.out.println(street);
            System.out.println(city);
            System.out.println(country);
            System.out.println(postalCode);
            System.out.println(orderOne);
            System.out.println(status);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
