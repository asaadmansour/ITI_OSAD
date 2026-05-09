package view;

import java.util.Scanner;
import Util.Utils;

public class UpdateClientView {
    public static Integer showMenu() {
        System.out.println();
        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│         UPDATE CLIENT INFO       │");
        System.out.println("├──────────────────────────────────┤");
        Utils.printMenu(new String[]{"Update Name", "Update Email", "Update Both", "Back"});
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
