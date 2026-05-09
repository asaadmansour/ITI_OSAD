/**
 * METHOD 2: Extending Thread Class
 * 
 * This class demonstrates creating a thread by extending the Thread class.
 * The run() method is overridden to define the thread's behavior.
 */
public class MyThreadClass extends Thread {
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
