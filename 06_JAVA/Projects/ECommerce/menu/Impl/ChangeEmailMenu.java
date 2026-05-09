package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;
import model.userModel.User;

public class ChangeEmailMenu implements Menu {
    ApplicationContext context = ApplicationContext.getInstance();
    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
		String email = sc.next();
        User user = context.getLoggedInUser();
		user.setEmail(email);
		System.out.println("Your email has been successfully changed");
        return;
    }
    @Override
    public void printMenuHeader() {
		System.out.println("***** CHANGE EMAIL *****");
		System.out.print("Enter new email: ");
    }
}
