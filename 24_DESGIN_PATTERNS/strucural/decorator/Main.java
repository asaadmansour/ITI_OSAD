public class Main {

    public static void main(String[] args) {
        Text text = new SimpleText();
        Text italicText = new ItalicDecorator(text);
        System.out.println(italicText.getDescription()); 
        Text italicUnderlineText = new ItalicDecorator(new UnderlineDecorator(text));
        System.out.println(italicUnderlineText.getDescription()); 
    }
}
