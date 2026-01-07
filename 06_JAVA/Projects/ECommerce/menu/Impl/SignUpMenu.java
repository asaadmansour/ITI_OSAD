package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;
import model.userModel.User;
import model.userModel.UserImp;
import service.UserManagementService;
import service.UserManagementServiceImp;

public class SignUpMenu implements Menu {
    private UserManagementService instance =  UserManagementServiceImp.getInstance();
    private ApplicationContext context = ApplicationContext.getInstance();
    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");	
        
    }
    @Override
    public void start() {
        printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();
		System.out.print("Please, enter your email: ");
		
		sc = new Scanner(System.in);
		String email = sc.nextLine();
        User user = new UserImp(firstName, lastName, email, password);
        String errorMsg = instance.registerUser(user);
        if(errorMsg == null || errorMsg.isEmpty()) {
            context.setLoggedInUser(user);
            System.out.println("User registered successfully!"); 
        } else {
            System.out.println(errorMsg);
        }

        
    }
}
