public class Button implements ClonableButton{
    private String color;
    private String content;
    private double xPosition;
    private double yPosition;

    public Button(String color, String content, double xPosition, double yPosition) {
        this.color = color;
        this.content = content;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getColor() {
        return color;
    }

    public String getContent() {
        return content;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }
    public Button clone() {
        return new Button(color,content,xPosition,yPosition);
    }
}
