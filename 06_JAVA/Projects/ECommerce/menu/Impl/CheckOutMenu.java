package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;
import model.orderModel.OrderImp;
import service.OrderManagementService;
import service.OrderManagementServiceImp;


public class CheckOutMenu implements Menu {
    private ApplicationContext context = ApplicationContext.getInstance();
    private OrderManagementService instance = OrderManagementServiceImp.getInstance();
    @Override
    public void start() {
		while (true) {
			printMenuHeader();
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();
            if(!createOrder(userInput)) {
                System.out.println("Invalid credit card number. Please try again.");
                continue;
            }
            context.getSessionCart().clear();
            System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
            break;
        }
        
    }
    private boolean createOrder(String creditCardNumber) {
        OrderImp order = new OrderImp();
        if(!order.isCreditCardNumberValid(creditCardNumber)) {
            return false;
        }
        order.setCreditCardNumber(creditCardNumber);
        order.setCustomerId(context.getLoggedInUser().getId());
        order.setProducts(context.getSessionCart().getProducts());
        instance.addOrder(order);
        return true;
    }
    @Override
    public void printMenuHeader() {
		System.out.println("***** CHECKOUT *****");
		System.out.print(
				"Enter your credit card number without spaces and press enter if you confirm purchase: ");
        
    }
}
