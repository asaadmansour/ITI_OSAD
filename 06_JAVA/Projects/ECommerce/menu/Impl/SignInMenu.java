package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;
import model.userModel.User;
import service.UserManagementService;
import service.UserManagementServiceImp;

public class SignInMenu implements Menu {
    private UserManagementService instance =  UserManagementServiceImp.getInstance();
    private ApplicationContext context = ApplicationContext.getInstance();
    @Override
    public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);

		System.out.print("Please, enter your email: ");
		String userEmail = sc.next();

		System.out.print("Please, enter your password: ");
		String userPassword = sc.next();
        User user = instance.getUserByEmail(userEmail);
        if(user != null && user.getPassword().equals(userPassword)) {
            System.out.printf("Glad to see you back %s %s", user.getFirstName(),
			user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
        } else {
            System.out.println("Incorrect email or password!");
        }
    }
    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign In *****");	
    }
}
