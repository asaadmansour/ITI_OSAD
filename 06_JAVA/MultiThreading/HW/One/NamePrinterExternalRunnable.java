/**
 * METHOD 1: Separate Class Implementing Runnable Interface
 * 
 * This class demonstrates creating a thread by implementing the Runnable interface.
 * The run() method contains the code that will be executed by the thread.
 */
public class NamePrinterExternalRunnable implements Runnable {
    
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