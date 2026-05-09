package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;
import model.userModel.User;

public class ChangePasswordMenu implements Menu {
    ApplicationContext context = ApplicationContext.getInstance();
    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
		String password = sc.next();
        User user = context.getLoggedInUser();
        user.setPassword(password);
        System.out.println("Your password has been successfully changed");
        return;
    }
    @Override
    public void printMenuHeader() {
        System.out.println("***** CHANGE PASSWORD *****");
		System.out.print("Enter new password: ");	
        
    }
}
