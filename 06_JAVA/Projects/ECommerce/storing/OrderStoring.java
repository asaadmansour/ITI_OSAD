package storing;

import java.util.List;

import model.orderModel.Order;

public interface OrderStoring {
    void saveOrders(List<Order> orders);
    List<Order> loadOrders();
}
