public class Main3 {
    public static void main(String[] args) {
        Button button = new Button("red","click",12.2032,13.5022);
        Button button1 = button.clone();
        button1.setColor("yellow");
        System.out.println(button1.getColor());
        System.out.println(button.getColor());
        LoginButton button2 = new LoginButton("red","click",12.2032,13.5022,"dsfjdkodjfkd");
        LoginButton button3 = button2.clone();
        button3.setToken("21sds12sa");
    }
}
