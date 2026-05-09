import java.util.Comparator;

public class CustomProductCompartor implements Comparator<Product>{
    // public int compare(Product p1,Product p2) {
    //     int result =  p1.getCategoryName().compareTo(p2.getCategoryName());
    //     if(result!=0)
    //         return result;
    //     else 
    //         return Double.compare(p1.getPrice(), p2.getPrice());
    // }\
    public int compare(Product p1,Product p2) {
        return Comparator
                .comparing(Product::getCategoryName)
                    .thenComparing(Product::getPrice)
                        .compare(p1, p2);
    }
}
