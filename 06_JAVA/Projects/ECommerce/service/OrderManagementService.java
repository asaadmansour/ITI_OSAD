package service;

import model.orderModel.Order;

public interface OrderManagementService {
    void addOrder(Order order);
	Order[] getOrdersByUserId(int userId);
    Order[] getOrders();

}
