package storing;
import model.productModel.Product;
import java.util.List;

public interface ProductStoring  {
    List<Product> loadProducts();
}
