package service;

import java.util.ArrayList;
import java.util.List;

import model.orderModel.Order;

public class OrderManagementServiceImp implements OrderManagementService{
    private static OrderManagementService instance;
    private Order[] orders = new Order[0];
    private OrderManagementServiceImp() {};
    public static OrderManagementService getInstance() {
        if(instance == null)
            instance = new OrderManagementServiceImp();
        return instance;
    }
    public void addOrder(Order order){
        Order[] newOrders = new Order[orders.length + 1];
        for(int i = 0; i < orders.length; i++) {
            newOrders[i] = orders[i];
        }
        newOrders[orders.length] = order;
        orders = newOrders;
    }
    public Order[] getOrdersByUserId(int userId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {      
            if (order.getCustomerId() == userId) {
                result.add(order);
            }
        }
        return result.toArray(new Order[result.size()]);
    }

    public Order[] getOrders() {
        return orders;
    }
    public void clearServiceState() {
        instance = null;
        orders = new Order[0];
    }
}
