import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonBTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"asaad","software engineer");
        Employee e2 = new Employee(2,"muhanad","architect");
        Employee[] emps = {e1,e2};
        List<Employee> empsList = new ArrayList<>();
        empsList.add(e1);
        empsList.add(e2);

        // serializing one object

        Jsonb json = JsonbBuilder.create();
        String result = json.toJson(e1);

        //deserializing one object
        Employee restore = json.fromJson(result, Employee.class);
        
        //serializing array
        String resultArray = json.toJson(emps);

        //deserializing array
        Employee[] restoreArray = json.fromJson(resultArray,Employee[].class);

        //serializing a generic collection
        String resultCollection = json.toJson(empsList);

        //deserializing a generic collection
        Employee[] restoreEmps = json.fromJson(resultCollection, Employee[].class);
        List<Employee> restoreEmpsList = new ArrayList<>(Arrays.asList(restoreEmps));
    }
}
