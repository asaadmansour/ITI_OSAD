    /**
     * In this file you will find violation of LSP. You need to refactor this code.
     */
    public class AreaCalculationOriginal {
        public static void main(String[] args) {
            RectangleOriginal rectangle = new RectangleOriginal(5, 5);
            System.out.println("Area: " + rectangle.calculateArea());
        }
    abstract class Shape {
        public abstract int calculateArea();
    }
    class RectangleOriginal extends Shape {
        private int width;
        private int height;

        public RectangleOriginal(int width, int height) {
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException();
            }
            this.width = width;
            this.height = height;
        }
        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }
        @Override
        public int calculateArea() {
            return width * height;
        }
    }

    class SquareOriginal extends Shape {
            int side;
            SquareOriginal(int side) {
                if(side<0) 
                    throw new IllegalArgumentException();
                this.side = side;
            }
            public void setSide(int side) {
                this.side = side;
            }
            public int getSide() {
                return side;
            }
            @Override
            public int calculateArea() {
            return side * side;
            }
        }
    }
