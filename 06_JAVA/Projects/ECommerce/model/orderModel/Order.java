package model.orderModel;

import model.productModel.Product;

public interface Order {
    boolean isCreditCardNumberValid(String userInput);

	void setCreditCardNumber(String userInput);

	void setProducts(Product[] products);

	void setCustomerId(int customerId);
	
	int getCustomerId();

}
