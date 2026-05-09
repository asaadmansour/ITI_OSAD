class Course implements Identifiable{
    private String courseName;
    private Integer courseId;
    private Integer creditHours;
    
    Course(String courseName,Integer courseId,Integer creditHours) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.creditHours = creditHours;
    }
    public String getCourseName() {
        return courseName;
    }
    public Integer getId() {
        return courseId;
    }
    public Integer getCreditHours() {
        return creditHours;
    }
        
}