package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;

public class SettingsMenu implements Menu {
	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";
    ApplicationContext context = ApplicationContext.getInstance();
    @Override
    public void start() {
        if(context.getLoggedInUser() == null) {
            System.out.println("You are not logged in. Please, sign in or create new account");
            return;
        }
        while(true) {
            printMenuHeader();
            System.out.println(SETTINGS);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next().toLowerCase();
            
            if(userInput.equals("menu")) {
                return;  // Exit back to main menu
            }
            
            int userInputNumber;
            try {
                userInputNumber = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }
            
            switch (userInputNumber) {
                case 1:
                    new ChangePasswordMenu().start();  // 1 = Password
                    break;
                case 2:
                    new ChangeEmailMenu().start();     // 2 = Email
                    break;
                default:
                    System.out.println("Only 1, 2 is allowed. Try one more time");
            }
        }
    }
    @Override
    public void printMenuHeader() {
        System.out.println("***** SETTINGS *****");		
    }
}
