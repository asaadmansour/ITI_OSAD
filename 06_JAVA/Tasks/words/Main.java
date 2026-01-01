package words;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] filterWordsByLength(int minLength,String[] words){
        return Arrays.stream(words)
            .filter(word -> word.length() >= minLength)
                .toArray(String[]::new);
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        int length;
        System.out.println("Enter words sperated by space: "); 
        text =sc.nextLine();
        System.out.println("Enter the minimum length: "); 
        length = sc.nextInt();
        String[] words = text.split("\\s+");
        String[] filteredWords = filterWordsByLength(length,words);
        for(String word:filteredWords) {
            System.out.println(word);
        }
        sc.close();
    }
}
