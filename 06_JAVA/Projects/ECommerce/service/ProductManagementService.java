package service;

import model.productModel.Product;

public interface ProductManagementService {
    Product[] getProducts();
	Product getProductById(int productIdToAddToCart);
    void clearServiceState();
}
