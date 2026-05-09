package view;

import Util.Utils;
import java.util.Scanner;

public class ClientView {
    public static Integer showMenu() {
        System.out.println();
        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│          CLIENT MANAGEMENT       │");
        System.out.println("├──────────────────────────────────┤");
        Utils.printMenu(new String[]{"Add Client", "View Client Details", "Update Client", "Delete Client","Borrow Item","Return Item","View Borrowed Items","Back to Main Menu"});
        System.out.println("└──────────────────────────────────┘");
        System.out.print("Select an option: ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String menuOption = sc.nextLine();
            try {
                return Integer.parseInt(menuOption);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
    }
}
