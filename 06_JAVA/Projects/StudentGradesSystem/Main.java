import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Utils.printMenu();
        MenuController menu = new MenuController();
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        while(input!=5) {
            switch(input) {
                case 1:
                    menu.addStudent();
                    break;
                case 2:
                    menu.printStudent();
                    break;
                case 3:
                    menu.studentCourseRegister();
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the course details in the format: (courseName, courseID, courseCreditHours)");
                    String courseDetails = sc.nextLine();
                    menu.courseEntry(courseDetails);
                    break;      
            }
            System.out.println("");
            System.out.println("");
            Utils.printMenu();
            input = sc.nextInt();
        }
        sc.close();
    }
}