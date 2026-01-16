package JsonWriter;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonWriterTest {
    public static void main(String[] args) {
        JsonObject json = Json.createObjectBuilder()
            .add("Name", "Asaad")
            .add("Age", 22)
            .add("Address", Json.createObjectBuilder()
                .add("Street", "Ahmed Tayseer")
                .add("Country", "Egypt"))
            .add("SKills", Json.createArrayBuilder()
                .add("Java")
                .add("PHP")
                .add("JavaScript"))
            .build();
        try (JsonWriter writer = Json.createWriter(new FileWriter("employee.json"))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}