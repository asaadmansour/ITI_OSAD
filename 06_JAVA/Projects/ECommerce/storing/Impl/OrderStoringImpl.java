package storing.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.orderModel.Order;
import storing.OrderStoring;

public class OrderStoringImpl implements OrderStoring {
    private static final String ORDERS_DATA_FILE_NAME = "orders.data";
    private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
	private static final String RESOURCES_FOLDER = "resources";
    private static OrderStoringImpl instance;
    public static OrderStoringImpl getInstance() {
		if (instance == null) {
			instance = new OrderStoringImpl();
		}
		return instance;
	}
    @Override
    public void saveOrders(List<Order> orders) {
        try(var oos = new ObjectOutputStream(new FileOutputStream(RESOURCES_FOLDER + File.separator + CURRENT_TASK_RESOURCE_FOLDER + File.separator + ORDERS_DATA_FILE_NAME))) {
            oos.writeObject(orders);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Order> loadOrders() {
        try (var ois = new ObjectInputStream(
                new FileInputStream(RESOURCES_FOLDER + File.separator + 
                    CURRENT_TASK_RESOURCE_FOLDER + File.separator + 
                    ORDERS_DATA_FILE_NAME))) {
            
            return (List<Order>) ois.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();  // Return empty list if file not found
        }
    }
}
