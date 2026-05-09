package model.orderModel;

import model.productModel.Product;
import java.io.Serializable;

public interface Order extends Serializable {
    boolean isCreditCardNumberValid(String userInput);

	void setCreditCardNumber(String userInput);

	void setProducts(Product[] products);

	void setCustomerId(int customerId);
	
	int getCustomerId();

}
