public class LoginButton extends Button{
    private String token;

    public LoginButton(String color, String content, double xPosition, double yPosition, String token) {
        super(color, content, xPosition, yPosition);
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginButton clone() {
        return new LoginButton( getColor(), getContent(), getxPosition(), getyPosition(),  token);
    }
}
