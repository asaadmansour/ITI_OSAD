package model.orderModel;

import model.productModel.Product;

public class OrderImp implements Order{
    private String creditCardNumber;
    private int customerId;
    private Product[] products;
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
    public boolean isCreditCardNumberValid(String userInput) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
