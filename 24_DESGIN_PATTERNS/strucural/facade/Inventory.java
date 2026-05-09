
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<String,Integer> products = new HashMap<>();

    public Inventory() {
        products.put("Laptop", 10);
        products.put("Phone", 25);
        products.put("Tablet", 15);
        products.put("Headphones", 30);
        products.put("Keyboard", 20);
    }
    public boolean order(String productName, Integer quantity) {
        if (products.containsKey(productName) && products.get(productName) >= quantity) {
            products.put(productName,products.getOrDefault(productName,0) - quantity);
            return true;
        }
        return  false;
    }
}
