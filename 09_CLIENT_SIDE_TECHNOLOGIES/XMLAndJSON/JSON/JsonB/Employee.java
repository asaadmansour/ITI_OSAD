public class Employee {
    private int id;
    private String name;
    private String jobTitle;
    public Employee(int id,String name,String jobTitle) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
    }
    public Employee() {
        this.id = 0;
        this.name = null;
        this.jobTitle = null;
    }
    public int getId() {
        return id;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public String getName() {
        return name;
    }
}