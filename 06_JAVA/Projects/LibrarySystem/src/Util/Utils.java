package Util;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import exception.ItemNotFoundException;
import model.Identifiable;

public class Utils {
    private final Scanner sc = new Scanner(System.in);

    public static void printMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println("│  " + (i + 1) + ". " + options[i]);
        }
    }

    public static boolean isString(String word) {
        if (word == null || word.isEmpty()) return false;
        return word.matches("[a-zA-Z ]+");
    }

    public static boolean isNumber(String word) {
        if (word == null) return false;
        try {
            Double.parseDouble(word);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static <T extends Identifiable> T isIdThere(Integer id, List<T> list) {
        for (T item : list) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    public static <T extends Identifiable> T findByIdOrThrow(Integer id, List<T> list,String entity) 
        throws ItemNotFoundException {
            for (T item : list) {
                if (id.equals(item.getId())) {
                    return item;
                }
            }
            throw new ItemNotFoundException(entity +" not found with ID: " + id);
        }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
    public int readInt(String msg) {
        while(true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    public int readInt(String msg, Predicate<Integer> validator,String errorMsg) {
        while (true) {
            int value = readInt(msg);
            if (validator.test(value)) return value;
            System.out.println(errorMsg);
        }
    }

    public String readString(String msg, Predicate<String> validator,String errorMsg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (validator.test(s)) return s;
            System.out.println(errorMsg);
        }
    }
}
