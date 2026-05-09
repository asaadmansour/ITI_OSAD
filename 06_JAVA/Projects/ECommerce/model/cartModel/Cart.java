package model.cartModel;

import model.productModel.Product;

public interface Cart {
    boolean isEmpty();

	void addProduct(Product productById);

	Product[] getProducts();

	void clear();

}
