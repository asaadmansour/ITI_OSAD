package menu.Impl;

import java.util.Scanner;

import context.ApplicationContext;
import menu.Menu;

public class MainMenu implements Menu {
    private static final String MENU_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign In"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";
    private static final String MENU_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";
    public static final String EXIT_COMMAND = "exit";
    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }
    public void start() {
        while(true) {
            if (context.getMainMenu() == null) {
				context.setMainMenu(this);
			}
            Menu menuToNavigate = null;
            mainLoop:while(true) {
            printMenuHeader();
            int commandNumber = 0; 
            Scanner sc = new Scanner(System.in);
            System.out.print("User input: ");
            String userInput = sc.next();
            if(userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                System.exit(0);
            } else {
                try {
                    commandNumber = Integer.valueOf(userInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
            }

            switch (commandNumber) {
                case 1:
                    menuToNavigate = new SignUpMenu();
                    break mainLoop;
                case 2:
                    if(context.getLoggedInUser() == null) {
                        menuToNavigate = new SignInMenu();
                    }
                    else {
                        menuToNavigate = new SignOutMenu();
                    } 
                    break mainLoop;
                case 3:
                    menuToNavigate = new ProductsMenu();
                    break mainLoop;
                case 4:
                    menuToNavigate = new OrdersMenu();
                    break mainLoop;
                case 5:
                    menuToNavigate = new SettingsMenu();
                    break mainLoop;
                case 6:
                    menuToNavigate = new CustomerListMenu();
                    break mainLoop;
                default:
                    System.out.println("Only 1, 2, 3, 4, 5, 6 is allowed. Try one more time.");
                    continue;
                        }       
                    }
                    menuToNavigate.start();
                }
            }
                @Override
                public void printMenuHeader() {
                    System.out.println("***** MAIN MENU *****");
                    if(context.getLoggedInUser() == null)
                        System.out.println(MENU_FOR_LOGGED_OUT_USER);
                    else {
                        System.out.println(MENU_FOR_LOGGED_IN_USER);
        }
    }
}
