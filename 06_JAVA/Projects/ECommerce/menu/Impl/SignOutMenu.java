package menu.Impl;

import context.ApplicationContext;
import menu.Menu;

public class SignOutMenu implements Menu {
    private ApplicationContext context = ApplicationContext.getInstance();
    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        System.out.println("You have been logged out successfully!");
    }
    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign Out *****");	
    }
}

