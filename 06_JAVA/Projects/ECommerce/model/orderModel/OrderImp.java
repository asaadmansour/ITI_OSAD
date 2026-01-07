package model.orderModel;

import java.util.Arrays;

import model.productModel.Product;

public class OrderImp implements Order{
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
    private String creditCardNumber;
    private int customerId;
    private Product[] products;
    public OrderImp(String creditCardNumber,int customerId,Product[] products) {
        this.creditCardNumber = creditCardNumber;
        this.customerId = customerId;
        this.products = products;
    }
    public OrderImp() {};
    @Override
    public void setCreditCardNumber(String userInput) {
        if(isCreditCardNumberValid(userInput))
            this.creditCardNumber = userInput;
        
    }
    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
        
    }
    
    @Override
    public void setProducts(Product[] products) {
        this.products = products;
        
    }
    @Override
    public int getCustomerId() {
        return customerId;
    }
    @Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER && 
				!creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0;
	}
    @Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
					"credit card number - " + this.creditCardNumber + "\t" + 
					"products - " + Arrays.toString(this.products);
	}
}
