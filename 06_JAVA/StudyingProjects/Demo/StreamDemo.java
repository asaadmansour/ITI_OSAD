import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("=== Example 1: Using Lambda ===");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.println(n));

        System.out.println("\n=== Example 2: Using Anonymous Class (same result) ===");
        numbers.stream()
            .filter(new Predicate<Integer>() {
                @Override
                public boolean test(Integer n) {
                    return n % 2 == 0;
                }
            })
            .forEach(new Consumer<Integer>() {
                @Override
                public void accept(Integer n) {
                    System.out.println(n);
                }
            });

        System.out.println("\n=== Example 3: Showing all functional interfaces ===");
        
        // Predicate - returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        
        // Function - transforms input to output
        Function<Integer, Integer> doubler = n -> n * 2;
        System.out.println("Double of 5: " + doubler.apply(5));
        
        // Consumer - accepts input, returns nothing
        Consumer<String> printer = s -> System.out.println("Message: " + s);
        printer.accept("Hello");
        
        // Supplier - takes no input, returns output
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random: " + randomSupplier.get());
        
        // BinaryOperator - takes two inputs of same type, returns same type
        BinaryOperator<Integer> adder = (a, b) -> a + b;
        System.out.println("3 + 7 = " + adder.apply(3, 7));

        System.out.println("\n=== Example 4: Complete stream with all interfaces ===");
        int sum = numbers.stream()
            .filter(new Predicate<Integer>() {           // Predicate<Integer>
                public boolean test(Integer n) {
                    return n > 5;
                }
            })
            .map(new Function<Integer, Integer>() {      // Function<Integer, Integer>
                public Integer apply(Integer n) {
                    return n * 2;
                }
            })
            .reduce(0, new BinaryOperator<Integer>() {   // BinaryOperator<Integer>
                public Integer apply(Integer a, Integer b) {
                    return a + b;
                }
            });
        System.out.println("Sum of doubled numbers > 5: " + sum);
    }
}
