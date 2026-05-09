public class UnderlineDecorator extends TextDecorator{
    public UnderlineDecorator(Text text) {
        super(text);
    }
    @Override
    public String getDescription() {
        return "Underline " + super.getDescription();
    }
}
