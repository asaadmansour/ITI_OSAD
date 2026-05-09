public class Main {
    public static void main(String[] args) {
        Complex<Integer> c1 = new Complex<>(3, 2);
        Complex<Double> c2 = new Complex<>(1.5, -4.0);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        Complex<Double> sum = c1.add(c2);
        System.out.println("c1 + c2 = " + sum);
        Complex<Double> diff = c1.subtract(c2);
        System.out.println("c1 - c2 = " + diff);
        Complex<Double> prod = c1.Multiply(c2);
        System.out.println("c1 * c2 = " + prod);
        Complex<Double> quot = c1.divide(c2);
        System.out.println("c1 / c2 = " + quot);
        Complex<Integer> c3 = new Complex<>(5, -7);
        Complex<Integer> c4 = new Complex<>(2, 3);
        System.out.println("\nc3 = " + c3 + ", c4 = " + c4);
        System.out.println("c3 + c4 = " + c3.add(c4));
    }
}
