
public class Solution {
    /*
    Create a Java program Title.java that reads 
    an integer N from input and prints 
    "I love Recursion" N times using recursion.
    */
    public static void printRecursion(int n) {
        if (n == 0) {
            return; 
        }
        System.out.println("I love Recursion");
        printRecursion(n - 1); 
    }
    /*Write a recursive Java method t
    o print numbers from 1 to N, 
    each on a separate line. */
    public static void printNumbers(int n) {
        if (n == 0) {
            return; 
        }
        printNumbers(n - 1);
        System.out.println(n); 
    }
    /*Write a recursive Java method 
    to print numbers from N to 1,
     separated by a single space. */
    public static void printNto1(int n) {
        if (n == 0) {
            return; 
        }
        System.out.print(n + " "); 
        printNto1(n - 1);
    }
    /*
    Write a recursive Java method 
    to calculate and print 
    the factorial of a given number N.
    */
    public static long factorial(int n) {
        if (n == 1) {
            return 1; 
        }
        return n * factorial(n - 1);
    }
    /*
    Write a recursive Java method 
    to find and print the 
    Nth Fibonacci number
    */
    public static int fibonacci(int n) {
        if (n == 1) return 0; 
        if (n == 2) return 1; 
        return fibonacci(n - 1) + fibonacci(n - 2); 
    }
    /*Write a recursive Java method to 
    print the elements at even indices 
    of an array in reversed order. */
    public static void printEvenReversed(int[] arr, int index) {
    if (index < 0) {
        return; 
    }
    System.out.print(arr[index] + " ");
    printEvenReversed(arr, index - 2); 
}
}