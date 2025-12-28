/*

In this file you can find violation of Interface Segregation Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.


*/

//Client code
// Client code
public class Demo {
    public static void main(String[] args) {

        Workable employeeWorker = new Employee();
        employeeWorker.work();

        Eatable employeeEater = new Employee();
        employeeEater.eat();

        Sleepable employeeSleeper = new Employee();
        employeeSleeper.sleep();

        Workable robotWorker = new Robot();
        robotWorker.work();
    }
}

//Original interface violating ISP
interface WorkerOriginal {
	void work();

	void eat();

	void sleep();
}

class Employee implements Workable, Eatable, Sleepable {

    @Override
    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public void eat() {
        System.out.println("Employee is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Employee is sleeping");
    }
}

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Robot implements Workable {

    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
