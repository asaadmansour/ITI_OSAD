import java.util.List;

public class Test {
    public void method(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }
}
