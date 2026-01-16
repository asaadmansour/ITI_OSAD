import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {
    public static void main(String[] main) {
        Employee e1 = new Employee(1,"asaad","swe");
        Employee e2 = new Employee(2,"muhanad","swe");
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        String json =  gson.toJson(e1);
        Employee restore = gson.fromJson(json, Employee.class);
        Employee[] emps = {e1,e2};
        String jsonArray = gson.toJson(emps);
        Employee[] restoreArray = gson.fromJson(jsonArray, Employee[].class);
        List<Employee> emplist = new ArrayList<>();
        emplist.add(e1);
        emplist.add(e2);
        String jsonList = gson.toJson(emplist);
        Employee[] tempArray = gson.fromJson(jsonList, Employee[].class);
        List<Employee> restoreList = new ArrayList<>(Arrays.asList(tempArray));
    }
}
