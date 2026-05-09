public class SignUpButton extends Button {
    private final String recaptcha;

    public SignUpButton(String color, String content, double xPosition, double yPosition, String recaptcha) {
        super(color, content, xPosition, yPosition);
        this.recaptcha = recaptcha;
    }
    public SignUpButton clone() {
        return new SignUpButton(getColor(),getContent(),getxPosition(),getyPosition(),recaptcha);
    }
}
