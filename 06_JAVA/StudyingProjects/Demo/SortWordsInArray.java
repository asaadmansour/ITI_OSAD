import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class SortWordsInArray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter words separated by space: ");
		String text = sc.nextLine();
		String[] words = text.split("\\s+");
		Arrays.sort(words, Comparator.comparing(String::length).reversed()
		.thenComparing(String::compareToIgnoreCase)
	);// .thenComparing())
		System.out.println(String.join(" ", words));
    }
}
