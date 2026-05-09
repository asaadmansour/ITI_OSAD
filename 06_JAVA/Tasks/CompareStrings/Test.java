public class Test{
    public static void main(String[] args){
        betterString longer = (s1,s2) -> {
            if(s1.length()>s2.length())
                return s1;
            else {
                return s2;
            }
        };
        String result = longer.check("asadsds", "asa");
        System.out.println(result);
    }
}
