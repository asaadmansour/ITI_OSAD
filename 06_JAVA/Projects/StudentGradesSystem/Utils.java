import java.util.StringTokenizer;
import java.util.List;
public class Utils {
    //Expecting a format(courseName, CourseId, CourseCreditHours)
    public static Course StringTokenizerCourseCreation(String courseDetails) {
        StringTokenizer st = new StringTokenizer(courseDetails," ");
        String tokens = "";
        while (st.hasMoreTokens()) {
            tokens += st.nextToken();
        }
        // System.out.println(st);
        String[] parts = tokens.split(",");
        String courseName = parts[0];
        int courseId = Integer.parseInt(parts[1]);
        int creditHours = Integer.parseInt(parts[2]);
        return new Course(courseName,courseId,creditHours);
        // return c1;
    } 
    public static void printMenu() {
        String[] options = {"Enter Student Details", "Print Student Details", "Register Student Courses", "Enter a Course", "Close the App"};
        for(int i=0;i < options.length;i++) {
            System.out.println(i+1 + "-" + options[i]);
        }
    }
    public static<T extends Identifiable> T isIdThere(Integer id, List<T> list) {
        for(T item : list) {
            if(id.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }
    // public static<T extends Identifiable> T isIdThere(Integer id, List<T> list) {
    //     for(T item : list) {
    //         if(id.equals(item.getId())) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

}
