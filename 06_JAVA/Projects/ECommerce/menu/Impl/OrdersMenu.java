package menu.Impl;

import context.ApplicationContext;
import menu.Menu;
import model.orderModel.Order;
import service.OrderManagementService;
import service.OrderManagementServiceImp;

public class OrdersMenu implements Menu {
    private ApplicationContext context = ApplicationContext.getInstance();
    private OrderManagementService instance = OrderManagementServiceImp.getInstance();
    @Override
	public void start() {
		printMenuHeader();
		if (context.getLoggedInUser() == null) {
			System.out.println(
					"Please, log in or create new account to see list of your orders");
			return;
		} else {
			printUserOrdersToConsole();
		}
	}
    private void printUserOrdersToConsole() {
		Order[] loggedInUserOrders = instance
				.getOrdersByUserId(context.getLoggedInUser().getId());
        if (loggedInUserOrders == null || loggedInUserOrders.length == 0) {
			System.out.println(
					"Unfortunately, you don't have any orders yet. "
					+ "Navigate back to main menu to place a new order");
		} else {
            for (Order order : loggedInUserOrders) {
                System.out.println(order);
            }
        }

    }
    @Override
    public void printMenuHeader() {
       System.out.println("***** MY ORDERS *****");	   
    }
    
}
