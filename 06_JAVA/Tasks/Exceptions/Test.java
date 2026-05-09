package java.TaskSix.TaskSixOne;

public class Test {
    public void TestOne(String num1, String num2) throws LeadingZeros, DivideByString  {
        if (!num1.matches("\\d+")) //[0-9]*
            throw new LeadingZeros("Invalid input: first value is not numeric");

        if (num1.charAt(0) == '0')
            throw new LeadingZeros("Leading zero! check your input");

        if (!num2.matches("\\d+"))
            throw new DivideByString("Invalid! Division by string!");

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);

        System.out.println(a / b);
    }
}
