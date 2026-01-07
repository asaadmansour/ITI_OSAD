package menu.Impl;

import menu.Menu;
import model.userModel.User;
import service.UserManagementService;
import service.UserManagementServiceImp;

public class CustomerListMenu implements Menu {
    private UserManagementService instance = UserManagementServiceImp.getInstance();
    @Override
    public void start() {
        printMenuHeader();
        User[] users = instance.getUsers();
        if (users.length == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
        }
    }
    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");	
        
    }
    
}
