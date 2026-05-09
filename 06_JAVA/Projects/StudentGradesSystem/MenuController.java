import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class MenuController {
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // private Student findStudent(Integer studentID) {
    //     for(Student s : students) {
    //         if(studentID.equals(s.getId())) {
    //             return s;
    //         }  
    //     }
    //     return null;
    // }
    // private Course findCourse(Integer courseID) {
    //     for(Course c : courses) {
    //         if(courseID.equals(c.getId())) {
    //             return c;
    //         } 
    //     }
    //     return null;
    // }

    public void addStudent() {
        System.out.println("Enter the student ID: ");
        Integer studentId = sc.nextInt();
        sc.nextLine();
        while(Utils.isIdThere(studentId,students) != null) {
            System.out.println("Duplicate id! Enter another id: ");
            studentId = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Enter the student full name: ");
        String studentFullName = sc.next();
        Student student = new Student(studentId,studentFullName);
        students.add(student);
        System.out.println("Student added successfully!");
    }
    public void printStudent() {
        System.out.println("###### STUDENT DETAILS ######");
        System.out.println("");
        for(Student student : students) {
            System.out.print(student.getId() + " " + student.getFullName() + "\n");
            ArrayList<String> list = student.getRegistrations();
            for(String course : list) {
                System.out.println(course);
            }
        }
        System.out.println("###### ############### ######");
    }


    public void studentCourseRegister(){
        System.out.println("Enter the student ID: ");
        Integer studentID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the course ID: ");
        Integer courseID = sc.nextInt();
        sc.nextLine();
        Student s = Utils.isIdThere(studentID,students); 
            while(Utils.isIdThere(courseID,s.getCourses()) != null) {
                System.out.println("Duplicate ID! Enter another course id: ");
                courseID = sc.nextInt();
                sc.nextLine();
            }
        Course c = Utils.isIdThere(courseID,courses); 
        System.out.println("Enter the course grade: ");
        Double courseGrade = sc.nextDouble();
        sc.nextLine();
        s.registerCourse(c, courseGrade);
        }


    public void courseEntry(String courseDetails) {
        Course course = Utils.StringTokenizerCourseCreation(courseDetails);
        if(Utils.isIdThere(course.getId(), courses)!= null) {
            System.out.println("\nDuplicate Id!");
        } else {
            courses.add(course);
            System.out.println("\nCourse is added successfully!");
        }
    }
}
