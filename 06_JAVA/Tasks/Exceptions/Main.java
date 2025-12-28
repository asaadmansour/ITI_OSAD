package java.TaskSix.TaskSixOne;

public class Main {
    public static void main(String[] args) {

        Test t = new Test();

        try {
            System.out.println("---- Test 1: Valid ----");
            t.TestOne("10", "2");

            System.out.println("---- Test 2: Leading zero ----");
            t.TestOne("012", "5");

            System.out.println("---- Test 3: First input not numeric ----");
            t.TestOne("abc", "5");

            System.out.println("---- Test 4: Division by string ----");
            t.TestOne("10", "hello");

            System.out.println("---- Test 5: Division by zero ----");
            t.TestOne("10", "0");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
