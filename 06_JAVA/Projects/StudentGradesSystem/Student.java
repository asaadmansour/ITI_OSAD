import java.util.ArrayList;
import java.util.List;
// import java.lang.*;
class Student implements Identifiable {
    Student(Integer studentId,String fullName) {
        this.studentId = studentId;
        this.fullName = fullName;
    }
    private Integer studentId;
    private String fullName;
    private ArrayList <CourseRegistration> registrations = new ArrayList<>();
    private class CourseRegistration {
        private Course course;
        private Double grade;

        CourseRegistration(Course course, Double grade) {
            this.course = course;
            this.grade = grade;
        }

        public Course getCourse() { return course; }
        public Double getGrade() { return grade; }
    }
    

    public void registerCourse(Course course, Double grade) {
        registrations.add(new CourseRegistration(course,grade));
    }
    public ArrayList<String> getRegistrations() {
        ArrayList<String> list = new ArrayList<>();
        
        for (CourseRegistration reg : registrations) {
            list.add(reg.getCourse().getCourseName() + " — " + reg.getGrade());
        }
        return list;
    }
    public void printReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full Name: " + fullName + "\nStudent ID: "+ studentId);
        System.out.println(sb);
    }
    public String getFullName() {
        return fullName;
    }
    @Override
    public Integer getId() {
        return studentId;
    }
    public List<Course> getCourses(){
        List<Course> courses = new ArrayList<>();
        for(CourseRegistration reg : registrations) {
            courses.add(reg.getCourse());
        }
        return courses;
    };
}
