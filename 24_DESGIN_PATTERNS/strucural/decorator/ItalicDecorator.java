public class ItalicDecorator extends TextDecorator{
    public ItalicDecorator(Text text) {
        super(text);
    }

    @Override
    public String getDescription() {
        return "Italic" + super.getDescription();
    }
}
