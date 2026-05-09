package view;

import java.util.Scanner;
import Util.Utils;

public class LibraryView {
    public static Integer showMenu() {
        System.out.println();
        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│       LIBRARY ITEM MANAGEMENT    │");
        System.out.println("├──────────────────────────────────┤");
        Utils.printMenu(new String[]{"Add Book", "Add Magazine", "View Item Details", "Update Item Title", "Delete Item", "Back to Main Menu"});
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
