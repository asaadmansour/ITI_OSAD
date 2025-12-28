import java.util.TreeMap;
import java.util.TreeSet;

public class myDictionary {
    private TreeMap<Character, TreeSet<String>> dictionary;
    myDictionary() {
        dictionary = new TreeMap<>();
    }
    public void addWord(String word) {
        char firstLetter = Character.toLowerCase(word.charAt(0));
        dictionary.putIfAbsent(firstLetter, new TreeSet<>());
        dictionary.get(firstLetter).add(word);
    }
    public void printWords() {
        for(char c : dictionary.keySet()) {
            System.out.println(c + " " + dictionary.get(c));
        }
    }
}
