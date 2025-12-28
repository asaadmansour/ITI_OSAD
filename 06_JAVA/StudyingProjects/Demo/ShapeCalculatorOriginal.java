import java.util.List;

/*

In this file you can find violation of Open / Closed Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.

*/
 abstract class Shape {
    public abstract double calculateTotalArea();
}
public class ShapeCalculatorOriginal {
    public double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            shape.calculateTotalArea();
            // Add more conditions for other shapes (e.g., Triangle)
        }
        return totalArea;
    }
}

// class  ShapeOriginal implements calculatable {
//     public void calculateTotalArea() ;
// }

class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    @Override
    public double calculateTotalArea() {
        return Math.PI * Math.pow(radius, 2);
        
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    @Override
    public double calculateTotalArea() {
        return width * height;
         
    }
}