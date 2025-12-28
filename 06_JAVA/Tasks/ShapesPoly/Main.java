import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Rectangle> rects = new ArrayList<>();
        List<Shape> shapes = new ArrayList<>();
        rects.add(new Rectangle());
        rects.add(new Rectangle());
        shapes.add(new Rectangle());
        shapes.add(new Circle());
        Test test = new Test();
        test.method(rects);    
        test.method(shapes);   
    }
}
