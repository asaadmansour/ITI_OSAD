package functionalandstream;

import java.math.BigDecimal;

public class Publisher {
    private int id;
    private String publisherName;
    public Publisher() {
        this.id = 0;
        this.publisherName = "";
    }
    public Publisher(int id,String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Id: " + id + ", Publisher Name: " + publisherName;
    }
}
