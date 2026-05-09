package view;

import java.util.Scanner;
import Util.Utils;

public class MenuView {
    public static Integer showMenu() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║       LIBRARY MANAGEMENT SYSTEM    ║");
        System.out.println("╠════════════════════════════════════╣");
        Utils.printMenu(new String[]{"Library Items", "Clients", "Exit"});
        System.out.println("╚════════════════════════════════════╝");
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
